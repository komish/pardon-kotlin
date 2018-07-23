/*  
 Pardon: A NATO Phonetic Alphabet Translator 
 Kotlin Hacking Project - https://github.com/komish/pardon-kotlin 
*/


/* 
 Defining our Mappings Here
 using 'val' instead of 'var' since
 we do not intend to change these values
*/
val letterMapping = mapOf( 
    // TODO: K could be changed to <Char> 
    "a" to "Alpha",
    "b" to "Bravo",
    "c" to "Charlie",
    "d" to "Delta",
    "e" to "Echo",
    "f" to "Foxtrot",
    "g" to "Golf",
    "h" to "Hotel",
    "i" to "India",
    "j" to "Juliet",
    "k" to "Kilo",
    "l" to "Lima",
    "m" to "Mike",
    "n" to "November",
    "o" to "Oscar",
    "p" to "Papa",
    "q" to "Quebec",
    "r" to "Romeo",
    "s" to "Sierra",
    "t" to "Tango",
    "u" to "Uniform",
    "v" to "Victor",
    "w" to "Whiskey",
    "x" to "X-Ray",
    "y" to "Yankee",
    "z" to "Zulu",
    "0" to "Zero",
    "1" to "One",
    "2" to "Two",
    "3" to "Three",
    "4" to "Four",
    "5" to "Five",
    "6" to "Six",
    "7" to "Seven",
    "8" to "Eight",
    "9" to "Nine"
)



fun translateWord(word : String): List<String?> {
    /*
     TODO: in defining this function, the inferred type of the return
     value seems to require me to use String? or a nullable string
     unclear as to why this is. Updating type of mapped to match
    */

    // return a list of characters<Char> from word
    val charMapping:List<Char> = word.map{ it }

    // convert list to a list of mapped words
    val mapped:List<String?> = charMapping.map { 
        // if it's lower or a number, just translate
        if( it.isLowerCase() or ("$it".toIntOrNull() != null) ) letterMapping["$it"] 
        // if it's upper, add indicator and translate
        else if(it.isUpperCase()) "CAPITAL-${letterMapping["$it".toLowerCase()]}"
        // anything else, just print it
        else it.toString()
    }
    return mapped
}

fun main(args : Array<String>) {
    if(args.size == 0){
        println("Helper to translate from plain text to NATO Phonetic spelling")
        println("Example Usage:\n\tjava -jar pardon.jar [string] ...")
    } else for(word in args){
        val result = translateWord(word)
        print('"' + "${word}" + '"' + "\n\n\t")
        for(translated in result){
            print("${translated} ")
        }
        // print two lines!
        println("\n")
    }
}

