Scenario: Dodawanie danych do tablicy haszujacej gdzie m=13

Given a new hash table
When add x by 13
Then hash value is 0
When add x by 8
Then hash value is 8
When add x by 26
Then hash value is 1
When add x by 3
Then hash value is 3
When add x by 5
Then hash value is 5