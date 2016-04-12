Scenario: Test push
Given a new stack
When push x by 2
Then length is 1
Then top is 2

When push x by 5
Then length is 2
Then top is 5

When push x by 8
Then length is 3
Then top is 8

When push x by 1
When push x by 2
When push x by 3
When push x by 4
When push x by 5
Then length is 8
Then top is 5
Then top is 5
Then top is 5