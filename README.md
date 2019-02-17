# BackbaseChallenge

A searchable list of cities that open on Google Maps upon selection. 

Due to the searching being done with a prefix, I decided a Trie was the best data structure to use for storing/searching. It was noted in the assignment that app start-up time is not as important as the live search, so I start by reading the json and converting it into an ArrayList of City, and then insert all City objects into the Trie. Once the Trie is created, I can search via prefix in O(m) where m is the length of the prefix.
