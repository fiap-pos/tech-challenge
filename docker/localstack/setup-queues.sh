#!/usr/bin/env bash

# Run the app using local stack SQS
export SQS_ENDPOINT=http://localhost:4566
export SQS_REGION=us-east-1

# Create the queue
aws --endpoint-url $SQS_ENDPOINT sqs create-queue --queue-name fila-producao --region $SQS_REGION
aws --endpoint-url $SQS_ENDPOINT sqs create-queue --queue-name pagamentos --region $SQS_REGION
aws --endpoint-url $SQS_ENDPOINT sqs create-queue --queue-name pedido-criado --region $SQS_REGION
