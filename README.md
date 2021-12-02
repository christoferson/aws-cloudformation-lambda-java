# aws-cloudformation-lambda-java
Cloudformation - Lambda - Java

Deploys a lambda with dependencies in a separate layer

# Build Library Layer Zip
gradle -q packageLibs
move build\distributions\aws-cloudformation-lambda-java.zip build\aws-cloudformation-lambda-java-lib.zip

# Build Code Zip

gradle build -i -x test

# Package and Deploy Lambda

aws cloudformation package --template-file template.yml --s3-bucket demo-cloudformation --output-template-file out-template.yml

aws cloudformation deploy --template-file out-template.yml --stack-name aws-cloudformation-lambda-java --capabilities CAPABILITY_NAMED_IAM

# Invoke Lambda  

aws cloudformation describe-stack-resource --stack-name aws-cloudformation-lambda-java --logical-resource-id LambdaFunction --query 'StackResourceDetail.PhysicalResourceId'

aws lambda invoke --function-name aws-cloudformation-lambda-java-LambdaFunction-xxx --payload file://invoke-payload.json invoke-result.json

cat invoke-result.json

# Delete Lambda / Cleanup

aws logs delete-log-group --log-group-name /aws/lambda/aws-cloudformation-lambda-java-LambdaFunction-OzbEWRqLGDjd

aws cloudformation delete-stack --stack-name aws-cloudformation-lambda-java

del -f out-template.yml invoke-result.json

rmdir build /s /q

rmdir target /s /q

del -f .gradle
