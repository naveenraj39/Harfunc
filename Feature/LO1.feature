Feature: Test


Scenario: Testing

Given user logged in "http://edc.devil.triomics.in.s3-website.ap-south-1.amazonaws.com/login"
When Enter into Site "Alit Edc Pani"
Then Enter into Study "Harfunc"
And Enter into Build Form
Then Add Screening Visit
And Add Age Field
And Add Height Field
And Add Weight Field
Then Add Hba1c Fields
And Add PCOS Date Fields
Then Add Covid vaccination date
And Add Birth Year
And Add Option Group
Then Add Gender Field