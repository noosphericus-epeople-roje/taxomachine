package org.opentree.tnrs.queries;

import org.apache.lucene.queryParser.QueryParser;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.IndexHits;
import org.opentree.properties.OTVocabularyPredicate;
import org.opentree.taxonomy.Taxon;
import org.opentree.taxonomy.Taxonomy;
import org.opentree.taxonomy.contexts.TaxonomyContext;
import org.opentree.taxonomy.contexts.TaxonomyNodeIndex;
import org.opentree.tnrs.TNRSHit;
import org.opentree.tnrs.TNRSMatchSet;
import org.opentree.tnrs.TNRSNameResult;
import org.opentree.tnrs.TNRSResults;
import org.opentree.exceptions.MultipleHitsException;

public class SimpleQuery extends AbstractBaseQuery {

	private String queryString;
	
	public SimpleQuery(Taxonomy taxonomy) {
		super(taxonomy);
	}
	
	public SimpleQuery(Taxonomy taxonomy, TaxonomyContext context) {
		super(taxonomy, context);
	}
    
    /**
     * Returns *ONLY* exact name or synonym matches to `searchString` within `context`.
     * 
     */
    public TNRSResults matchExact(String searchString) {
    	setQueryString(searchString);
    	runQuery();
    	return getResults();
    }
    
    /**
     * Initialize the query with a query string
     * @param queryString
     * @return
     */
    public SimpleQuery setQueryString(String queryString) {
    	clear();
    	this.queryString = QueryParser.escape(queryString);
    	return this;
    }
    
    /**
     * Run the query using the set string and context
     */
    public SimpleQuery runQuery() {
        
    	results = new TNRSResults();
    	IndexHits<Node> hits = null;
    	try {
    		hits = context.getNodeIndex(TaxonomyNodeIndex.PREFERRED_TAXON_BY_NAME_OR_SYNONYM).query(OTVocabularyPredicate.OT_OTT_TAXON_NAME.propertyName(), queryString); //.replace(" ", "\\ "));

        	 // at least 1 hit; prepare to record matches
        	 TNRSMatchSet matches = new TNRSMatchSet(taxonomy);

        	 for (Node hit : hits) {
                // add this match to the match set
                Taxon matchedTaxon = taxonomy.getTaxon(hit);
                matches.addMatch(new TNRSHit().setMatchedTaxon(matchedTaxon));
        	 }

        	 // add matches to the TNRS results
            results.addNameResult(new TNRSNameResult(queryString, matches));
	            
         } finally {
         	hits.close();
         }
    	
         return this;
    }

    /**
     * Return the results of the last query
     */
    @Override
    public TNRSResults getResults() {
        return results;
    }
    
	/**
	 * Set the context to `context`. If `context` is null, the context will be set to ALLTAXA.
	 * @param context
	 */
	@Override
	public SimpleQuery setContext(TaxonomyContext context) {
		super.setContext(context);
		return this;
	}
	
	/**
	 * Clear the results and search strings from last query. Also called by the constructor to initialize the query.
	 */
	@Override
	public SimpleQuery clear() {
		queryString = "";
		results = new TNRSResults();
		return this;
	}

	/**
	 * SimpleQuery has no parameters to return to defaults; this just returns the object.
	 */
	@Override
	public SimpleQuery setDefaults() {
		return this;
	}
}
