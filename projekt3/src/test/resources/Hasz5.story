Scenario : przetestowanie reszty

Given a new hash table
When add wrong x throw exception
When add null x throw exception
When add x by 13
When add x by 12

Given a new hash table
When add x by 13
Then hash value is 0
When add x by 26
Then hash value is 1
When add x by 39
Then hash value is 2
Then delete x by 26




