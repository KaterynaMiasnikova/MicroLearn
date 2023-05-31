package kd.microlearn.python
import org.apache.commons.text.similarity.CosineDistance
import java.io.BufferedReader
import java.io.InputStreamReader


class ModuleAI {
    private val MAX_PORTION_LENGTH = 200
    private val MIN_SIMILARITY_THRESHOLD = 0.8

    // Function to generate material and divide it into portions
    fun generateMaterial(data: String): List<String> {
        val portions = mutableListOf<String>()
        val sentences = segmentSentences(data)

        var currentPortion = ""
        for (sentence in sentences) {
            val updatedPortion = if (currentPortion.isNotEmpty()) "$currentPortion $sentence" else sentence

            if (updatedPortion.length <= MAX_PORTION_LENGTH && checkSimilarity(currentPortion, sentence)) {
                currentPortion = updatedPortion
            } else {
                portions.add(currentPortion)
                currentPortion = sentence
            }
        }

        if (currentPortion.isNotEmpty()) {
            portions.add(currentPortion)
        }

        return portions
    }

    private fun segmentSentences(text: String): List<String> {
        // Dummy implementation for demonstration purposes
        return text.split('.').map { it.trim() }.filter { it.isNotEmpty() }
    }

    private fun checkSimilarity(portion: String, sentence: String): Boolean {
        val distance = CosineDistance()
        return distance.apply(portion, sentence) >= MIN_SIMILARITY_THRESHOLD
    }

    // Function to regenerate material based on feedback
    fun regenerateMaterial(feedback: String, portion: String): String {
        return when (feedback) {
            "Sentences are not logically connected enough" -> rewriteForLogicalConnection(portion)
            "Too short portion" -> rewriteForLength(portion)
            else -> portion // No changes needed for "Good quality of material"
        }
    }

    private fun paraphrase(sentence: String): String {
        val process = Runtime.getRuntime().exec("python paraphraser.py")

        val writer = process.outputStream.bufferedWriter()
        writer.write(sentence)
        writer.newLine()
        writer.flush()
        writer.close()

        val reader = BufferedReader(InputStreamReader(process.inputStream))
        val paraphrasedSentence = reader.readLine()
        reader.close()

        return paraphrasedSentence
    }

    // AI algorithm for rewriting material based on logical connection
    private fun rewriteForLogicalConnection(portion: String): String {
        val sentences = segmentSentences(portion)
        val rewrittenSentences = mutableListOf<String>()

        for (sentence in sentences) {
            val paraphrasedSentence = paraphrase(sentence)
            rewrittenSentences.add(paraphrasedSentence)
        }

        return rewrittenSentences.joinToString(" ")
    }

    // AI algorithm for rewriting material based on portion length
    private fun rewriteForLength(portion: String): String {
        val nextPortion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam vestibulum tortor quis erat posuere, sit amet auctor leo aliquam. Sed vel augue lacus. Morbi vel dolor tellus. In hac habitasse platea dictumst. Fusce fringilla sem a massa tempor, ut sagittis ex faucibus. Integer tristique pellentesque varius. Maecenas non nulla nec mauris semper ultricies ac et odio. Sed malesuada, turpis ac pellentesque aliquet, libero nulla consequat nibh, eu vulputate sapien massa in odio. Proin efficitur, leo nec suscipit rutrum, ipsum mauris fringilla nisl, sit amet hendrerit leo dui in tellus."

        return "$portion $nextPortion"
    }


}


//import edu.stanford.nlp.pipeline.StanfordCoreNLP
//import org.apache.commons.text.similarity.CosineSimilarity
//
//class ModuleAI(private val database: AppDatabase) {
//    private val cosineSimilarity = CosineSimilarity()
//    private val pipeline: StanfordCoreNLP
//
//    init {
//        val properties = Properties()
//        properties.setProperty("annotators", "tokenize, ssplit")
//        pipeline = StanfordCoreNLP(properties)
//    }
//
//    fun generateMaterial(data: String): List<String> {
//        val annotation = annotateText(data)
//        val sentences = extractSentences(annotation)
//
//        val regeneratedMaterial = generateLogicalMaterial(orderedPortions, sentences)
//
//        // Save the regenerated material to the database
//        val startIndex = orderedPortions.size
//        regeneratedMaterial.forEachIndexed { index, portion ->
//            val portionModel = PortionModel(startIndex + index, portion)
//            database.portionDao().insert(portionModel)
//        }
//
//        return regeneratedMaterial
//    }
//
//    fun regenerateMaterial(material: String, userFeedback: Feedback): List<String> {
//        val orderedPortions = database.portionDao().getAll().map { it.portion }
//        val startIndex = orderedPortions.indexOf(material) + 1
//        val regeneratedMaterial = generateLogicalMaterial(orderedPortions, startIndex, userFeedback)
//
//        // Save the regenerated material to the database
//        regeneratedMaterial.forEachIndexed { index, portion ->
//            val portionModel = PortionModel(startIndex + index, portion)
//            database.portionDao().insert(portionModel)
//        }
//
//        return regeneratedMaterial
//    }
//
//    private fun annotateText(text: String): Annotation {
//        val annotation = Annotation(text)
//        pipeline.annotate(annotation)
//        return annotation
//    }
//
//    private fun extractSentences(annotation: Annotation): List<String> {
//        val sentences = mutableListOf<String>()
//        val sentenceAnnotations = annotation.get(CoreAnnotations.SentencesAnnotation::class.java)
//        for (sentenceAnnotation in sentenceAnnotations) {
//            val sentence = sentenceAnnotation.get(CoreAnnotations.TextAnnotation::class.java)
//            sentences.add(sentence)
//        }
//        return sentences
//    }
//
//    private fun generateLogicalMaterial(sentences: List<String>, startIndex: Int, userFeedback: Feedback? = null): List<String> {
//        val logicalMaterial = mutableListOf<String>()
//
//        for (i in startIndex until sentences.size) {
//            val lastSentence = logicalMaterial.lastOrNull()
//            val currentSentence = sentences[i]
//            if (lastSentence != null && isContinuationOfLogicalContent(lastSentence, currentSentence, userFeedback)) {
//                logicalMaterial[logicalMaterial.size - 1] = "$lastSentence $currentSentence"
//            } else {
//                logicalMaterial.add(currentSentence)
//            }
//        }
//
//        return logicalMaterial
//    }
//
//    private fun isContinuationOfLogicalContent(previousSentence: String, nextSentence: String, userFeedback: Feedback?): Boolean {
//        val similarityScore = cosineSimilarity.cosineSimilarity(previousSentence, nextSentence)
//        val similarityThreshold = if (userFeedback?.note ?: 0 < 4) 0.6 else 0.8
//
//        return similarityScore >= similarityThreshold && (userFeedback?.summary.isNullOrBlank() || userFeedback?.summary == nextSentence)
//    }
//}
