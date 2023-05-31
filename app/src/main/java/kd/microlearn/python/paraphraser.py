from nltk.corpus import wordnet
from nltk.tokenize import word_tokenize


def paraphrase(sentence):
    tokens = word_tokenize(sentence)
    paraphrased_tokens = []

    for token in tokens:
        synonyms = []
        for syn in wordnet.synsets(token):
            for lemma in syn.lemmas():
                synonyms.append(lemma.name())

        if len(synonyms) > 0:
            paraphrased_word = synonyms[0]  # Select the first synonym
            paraphrased_tokens.append(paraphrased_word)
        else:
            paraphrased_tokens.append(token)

    paraphrased_sentence = ' '.join(paraphrased_tokens)
    return paraphrased_sentence