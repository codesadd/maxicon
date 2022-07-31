import com.opencsv.CSVReader
import java.io.File
import java.io.FileReader
import java.util.*


fun main(args: Array<String>) {

    val csvFile = args[0]
    val sourceIcon = args[1]
    println("Load Data CSV: $csvFile")
    println("Load Source SVG: $sourceIcon")
    val records: MutableList<List<String?>> = ArrayList()
    try {
        CSVReader(FileReader(args[0])).use { csvReader ->
            var values: Array<String?>
            while (csvReader.readNext().also { values = it } != null) {
                records.add(Arrays.asList(*values))
            }
        }
    } catch (e: Exception) {
        println("Loading Data success -->")
    }
    println("Found Icon in CSV: ${records.size - 1}")

    for (e in records){
        val fileName = e[0]
        val keyWord = e[1]
        val file = File("$sourceIcon$fileName.svg")
        file.renameTo(File("$sourceIcon$keyWord.svg"))
        println("Done! rename from $fileName --> $keyWord")
    }
}