package kd.microlearn.python

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class WikipediaDataRetriever {
    fun retrieveData(theme: String): String? {
        val url = getWikipediaURL(theme)
        val document = fetchWebPage(url)
        return extractContent(document)
    }

    private fun getWikipediaURL(theme: String): String {
        val encodedTheme = theme.replace(" ", "_")
        return "https://en.wikipedia.org/wiki/$encodedTheme"
    }

    private fun fetchWebPage(url: String): Document {
        return Jsoup.connect(url).get()
    }

    private fun extractContent(document: Document): String? {
        val contentElement = document.getElementById("mw-content-text")
        return contentElement?.text()
    }
}