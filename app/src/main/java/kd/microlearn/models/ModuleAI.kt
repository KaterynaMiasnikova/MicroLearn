//package kd.microlearn.models
//
//import edu.stanford.nlp.pipeline.CoreDocument
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
//    fun processData(data: String): List<String> {
//        val annotation = annotateText(data)
//        val sentences = extractSentences(annotation)
//        val orderedPortions = database.portionDao().getAll().map { it.portion }
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
