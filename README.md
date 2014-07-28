Character Parser
===========

A simple parser to aid in the loading of Character files.

An example character file would be:

	[ACCOUNT]
	character-name = TEST
	character-password = test
	
	[BANK]
	character-bank = 0 1 2
	character-bank1 = 0 1 2
	
	[ITEMS]
	character-item = 0 1 2
	character-item = 0 1 2

This parser converts that into Sections which you may get by name to parse them.

Example:
	
	CharacterFile ch = CharacterFileParser.parse(new File("character.txt"));
	
	Section account = ch.getSection("account");
	
	for (Map.Entry<String, List<String>> entry : account.getValues().entrySet()) {
		System.out.println("Entry name: " + entry.getKey());
		System.out.println("Entry values: " + entry.getValue();
	}
	
You can also parse only certain sections of the file, like so:

	CharacterFile ch = CharacterFileParser.parse(new File("character.txt"), new SectionNameFilter("account", "items"));
    
    Section account = ch.getSection("account");
    
    for (Map.Entry<String, List<String>> entry : account.getValues().entrySet()) {
    	System.out.println("Entry name: " + entry.getKey());
    	System.out.println("Entry values: " + entry.getValue();
    }