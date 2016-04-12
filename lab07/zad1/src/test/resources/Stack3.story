Scenario : Pop exception and null stack
Given a new stack
Then stack is null
When push x by 1
Then stack is not null
When pop from stack
Then stack is null
Then pop throws exception 
