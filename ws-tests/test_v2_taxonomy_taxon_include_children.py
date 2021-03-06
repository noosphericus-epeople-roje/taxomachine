#!/usr/bin/env python
import sys, os
from opentreetesting import test_http_json_method, config
DOMAIN = config('host', 'apihost')
SUBMIT_URI = DOMAIN + '/v2/taxonomy/taxon'
test, result = test_http_json_method(SUBMIT_URI, "POST",
                                        data={"ott_id":515698, "include_children":"true"},
                                        expected_status=200,
                                        return_bool_data=True)
if not test:
    sys.exit(1)
if u'ot:ottId' not in result:
    sys.stderr.write('ot:ottId not found in result')
    sys.exit(1)
if result[u'ot:ottId'] != 515698:
    sys.stderr.write('Incorrect ottid in returned taxon {}',format(result[u'ot:ottId']))
    sys.exit(1)
if u'children' not in result:
    errstr = 'No children returned when expected in taxon report: {}'
    sys.stderr.write(errstr.format(result))
    sys.exit(1)
if not 503056 in map(lambda c:c[u'ot:ottId'], result[u'children']):
    sys.stderr.write('Expected child not found in result')
    sys.exit(1)
