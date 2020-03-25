#!/bin/sh
docker build . -t flight-info-oag-adapter
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 flight-info-oag-adapter"
