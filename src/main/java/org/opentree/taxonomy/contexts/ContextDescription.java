package org.opentree.taxonomy.contexts;

import org.opentree.taxonomy.contexts.ContextGroup;

/**
 * Definitions for the various taxonomic contexts. These are used to access the node indexes in order to locate nodes by name, synonym name, etc.
 * This enum defines the taxonomic scope of the various contexts. It is referred to by the TaxonomySynthesizer.makeContexts() method, which will
 * make context-specific node indexes for all the contexts defined here, and is also used when initializing an instance of the TaxonomyContext class,
 * through which access to all the context-specific node indexes themselves is provided.
 * 
 * Definitions for new contexts should be created in this enum.
 * 
 * For more information on how to use the context-specific indexes, refer to the documentation in the TaxonomyContext class file.
 * 
 * @author cody hinchliff
 *
 */
public enum ContextDescription {

    /* *** NOTE: names must be unique!  TODO: use ott ids instead of names, to avoid this... */

    // Enum name         Name ***           Group                   Index suffix        Node name string    Nomenclature
    ALLTAXA             ("All life",        ContextGroup.LIFE,      "",                 "life",             Nomenclature.Undefined),

    // MICROBES group
    BACTERIA            ("Bacteria",        ContextGroup.MICROBES,  "Bacteria",         "Bacteria",         Nomenclature.ICNP),
    SAR					("SAR group",		ContextGroup.MICROBES,	"SAR",				"SAR",				Nomenclature.Undefined),
//  ARCHAEA				("Archaea",			ContextGroup.MICROBES,	"Archaea",			"Archaea",			Nomenclature.ICNP), // I don't think this name is unique
    EXCAVATA			("Excavata",		ContextGroup.MICROBES,	"Excavata",			"Excavata",			Nomenclature.Undefined),
    AMOEBAE				("Amoebae",			ContextGroup.MICROBES,	"Amoebae",			"Amoebozoa",		Nomenclature.ICZN),
    CENTROHELIDA		("Centrohelida",	ContextGroup.MICROBES,	"Centrohelida",		"Centrohelida",		Nomenclature.ICZN),
    HAPTOPHYTA			("Haptophyta",		ContextGroup.MICROBES,	"Haptophyta",		"Haptophyta",		Nomenclature.Undefined),
    APUSOZOA			("Apusozoa",		ContextGroup.MICROBES,	"Apusozoa",			"Apusozoa",			Nomenclature.ICZN),
    DIATOMS				("Diatoms",			ContextGroup.MICROBES,	"Diatoms",			"Bacillariophyta",	Nomenclature.ICN),
    CILIATES			("Ciliates",		ContextGroup.MICROBES,	"Ciliates",			"Ciliophora",		Nomenclature.Undefined),
    FORAMS				("Forams",			ContextGroup.MICROBES,	"Forams",			"Foraminifera",		Nomenclature.ICZN),

    // ANIMALS group
    METAZOA             ("Animals",         ContextGroup.ANIMALS,   "Animals",          "Metazoa",          Nomenclature.ICZN),
    BIRDS               ("Birds",           ContextGroup.ANIMALS,   "Birds",            "Aves",             Nomenclature.ICZN),
    TETRAPODS           ("Tetrapods",       ContextGroup.ANIMALS,   "Tetrapods",        "Tetrapoda",        Nomenclature.ICZN),
    MAMMALS             ("Mammals",         ContextGroup.ANIMALS,   "Mammals",          "Mammalia",         Nomenclature.ICZN),
    AMPHIBIANS          ("Amphibians",      ContextGroup.ANIMALS,   "Amphibians",       "Amphibia",         Nomenclature.ICZN),
    VERTEBRATES         ("Vertebrates",     ContextGroup.ANIMALS,   "Vertebrates",      "Vertebrata",       Nomenclature.ICZN),
    ARTHROPODS          ("Arthropods",      ContextGroup.ANIMALS,   "Arthopods",        "Arthropoda",       Nomenclature.ICZN),
    MOLLUSCS            ("Molluscs",        ContextGroup.ANIMALS,   "Molluscs",         "Mollusca",         Nomenclature.ICZN),
// name Nematodes may not be unique?
//  NEMATODES           ("Nematodes",       ContextGroup.ANIMALS,   "Nematodes",        "Nematoda",         Nomenclature.ICZN),
    PLATYHELMINTHES     ("Platyhelminthes", ContextGroup.ANIMALS,   "Platyhelminthes",  "Platyhelminthes",  Nomenclature.ICZN),
    ANNELIDS            ("Annelids",        ContextGroup.ANIMALS,   "Annelids",         "Annelida",         Nomenclature.ICZN),
    CNIDARIA            ("Cnidarians",      ContextGroup.ANIMALS,   "Cnidarians",       "Cnidaria",         Nomenclature.ICZN),
    ARACHNIDES          ("Arachnides",      ContextGroup.ANIMALS,   "Arachnids",		"Arachnida",        Nomenclature.ICZN),
    INSECTS             ("Insects",         ContextGroup.ANIMALS,   "Insects",          "Insecta",          Nomenclature.ICZN),

    // FUNGI group
    FUNGI               ("Fungi",           ContextGroup.FUNGI,     "Fungi",            "Fungi",            Nomenclature.ICN),
    
    // PLANTS group
    LAND_PLANTS         ("Land plants",     ContextGroup.PLANTS,    "Plants",           "Embryophyta",      Nomenclature.ICN),
    HORNWORTS           ("Hornworts",       ContextGroup.PLANTS,    "Anthocerotophyta", "Anthocerotophyta", Nomenclature.ICN),
    MOSSES              ("Mosses",          ContextGroup.PLANTS,    "Bryophyta",        "Bryophyta",        Nomenclature.ICN),
    LIVERWORTS          ("Liverworts",      ContextGroup.PLANTS,    "Marchantiophyta",  "Marchantiophyta",  Nomenclature.ICN),
    VASCULAR_PLANTS     ("Vascular plants", ContextGroup.PLANTS,    "Tracheophyta",     "Tracheophyta",     Nomenclature.ICN),
    LYCOPHYTES          ("Club mosses",     ContextGroup.PLANTS,    "Lycopodiophyta",   "Lycopodiophyta",   Nomenclature.ICN),
    FERNS               ("Ferns",           ContextGroup.PLANTS,    "Moniliformopses",  "Moniliformopses",  Nomenclature.ICN),
    SEED_PLANTS         ("Seed plants",     ContextGroup.PLANTS,    "Spermatophyta",    "Spermatophyta",    Nomenclature.ICN),
    FLOWERING_PLANTS    ("Flowering plants",ContextGroup.PLANTS,    "Magnoliophyta",    "Magnoliophyta",    Nomenclature.ICN),
//    MAGNOLIIDS          ("Magnoliids",      ContextGroup.PLANTS,    "Magnoliids",       "magnoliids",       Nomenclature.ICBN), // apparently the name 'magnoliids' no longer exists
    MONOCOTS            ("Monocots",        ContextGroup.PLANTS,    "Monocots",         "Liliopsida",       Nomenclature.ICN),
    EUDICOTS            ("Eudicots",        ContextGroup.PLANTS,    "Eudicots",         "eudicotyledons",   Nomenclature.ICN),
    ASTERIDS            ("Asterids",        ContextGroup.PLANTS,    "Asterids",         "asterids",         Nomenclature.ICN),
    ROSIDS              ("Rosids",          ContextGroup.PLANTS,    "Rosids",           "rosids",           Nomenclature.ICN);
    
    public final String name;
    public final ContextGroup group;
    public final String nameSuffix;
    public final String licaNodeName;
    public final Nomenclature nomenclature;

    ContextDescription (String label, ContextGroup group, String nameSuffix, String nodeName, Nomenclature nomenclature) {
        this.name = label;
        this.group = group;
        this.nameSuffix = nameSuffix;
        this.licaNodeName = nodeName;
        this.nomenclature = nomenclature;
    }
}