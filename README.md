# emailMicroService

This is a simple SPRING BOOT MICROSERVICE example wherein one microservice(service-1) is responsible for persisting the data
in table "EmailToSend" and another microservice (service-2) tracks the data from service-1 and uses scheduler to send an email to 
respective email addresses with status 'N'.
