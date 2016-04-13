Scenario: Usuwanie

Given a new hash table
When add x by 13
Then delete x by 13
When add x by 8
Then delete x by 8

Given full hash table
Then throw exception delete x by 13