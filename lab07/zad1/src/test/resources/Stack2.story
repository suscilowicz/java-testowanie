Scenario: Test pop and top
Given a new stack
When push x by 1
When push x by 2
When push x by 3
When push x by 4
Then length is 4
Then top is 4

When pop from stack
Then length is 3
Then top is 3

When pop from stack
Then length is 2
Then top is 2

When pop from stack
Then length is 1
Then top is 1

When pop from stack
Then stack is null
Then top throws exception
