#!/usr/bin/env python
from check import *

status = 0

status += \
simple_test('/v3/taxonomy/about',
            {},
            is_right=check_taxonomy_description_blob)

sys.exit(status)
