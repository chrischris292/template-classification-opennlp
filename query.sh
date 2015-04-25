#!/usr/bin/bash

curl -H "Content-Type: application/json" -d '{"sentence": "this is a good one"}' http://localhost:8000/queries.json
