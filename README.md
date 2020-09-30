# dropwizard-spanner-demo

This project has been created to demonstrate how DropWizard can use the Spanner JDBC driver. 

## Prerequisites

Beyond a JDK you need the Google Cloud SDK and Docker Desktop:
- Google Cloud SDK - instructions are [here](https://cloud.google.com/sdk/docs/install).
- Docker Desktop - instructions are [here](https://www.docker.com/products/docker-desktop).

## How to run

In one terminal window start the Spanner emulator:

```$ gcloud beta emulators spanner start```

In another terminal window, create an emulator configuration:

```
$ gcloud config configurations create demo
$ gcloud config set auth/disable_credentials true
$ gcloud config set project demo-project
$ gcloud config set api_endpoint_overrides/spanner http://localhost:9020
```
If you already have one, select it instead:

```
$ gcloud config configurations activate demo
```

Finally, create the instance and database:

```
$ gcloud spanner instances create demo-instance --config=demo-confign--description="Demo instance" --nodes=1
$ gcloud spanner databases create demo --instance=demo-instance
```

Finally, run the DropWizard project:

```
$ ./gradlew clean run
```
