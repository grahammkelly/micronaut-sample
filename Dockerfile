FROM oracle/graalvm-ce:19.3.1-java8 as graalvm
# For JDK 11
#FROM oracle/graalvm-ce:19.3.1-java11 as graalvm
RUN gu install native-image

COPY . /home/app/flight-info-oag-adapter
WORKDIR /home/app/flight-info-oag-adapter

RUN native-image --no-server -cp build/libs/flight-info-oag-adapter-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/flight-info-oag-adapter/flight-info-oag-adapter /app/flight-info-oag-adapter
ENTRYPOINT ["/app/flight-info-oag-adapter"]
