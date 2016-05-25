package translate.dna

/**
  * Created by will on 14/05/16.
  */
class TranslationSpec extends TestBase {

  "Translation#translateSequence" should "return an empty String if the gene sequence is less than 3 characters" in {
    Translation.translateSequence("AU") should be("")
  }

  it should "return an empty String if the gene sequence has one codon and that codon is invalid" in {
    Translation.translateSequence("QQQ") should be("")
  }

  it should "return 'Phe' if the gene sequence contains one codon matching the Phe pattern" in {
    Translation.translateSequence("UUU") should be("Phe")
  }

  it should "return 'Phe' if the gene sequence contains one codon matching the Phe pattern and one extraneous character" in {
    Translation.translateSequence("UUUAU") should be("Phe")
  }

  it should "return 'PheStop' if the gene sequence contains two codons where the 1st matches the Phe pattern and the 2nd matches the Stop pattern" in {
    Translation.translateSequence("UUUUAA") should be("PheStop")
  }

  "Translation#findAndTranslate" should "return None if no match is found" in {
    Translation.findAndTranslate("BBB", Translation.codonPatterns) should be(None)
  }

  it should "return 'Phe' if the Codon is 'UUU'" in {
    Translation.findAndTranslate("UUU", Translation.codonPatterns) should be(Some("Phe"))
  }

  it should "return 'Phe' if the Codon is 'UUC'" in {
    Translation.findAndTranslate("UUC", Translation.codonPatterns) should be(Some("Phe"))
  }

  it should "return 'Leu' if the Codon is 'UUA'" in {
    Translation.findAndTranslate("UUA", Translation.codonPatterns) should be(Some("Leu"))
  }

  it should "return 'Leu' if the Codon is 'UUG'" in {
    Translation.findAndTranslate("UUG", Translation.codonPatterns) should be(Some("Leu"))
  }

  it should "return 'Leu' if the Codon starts with 'CU'" in {
    Translation.findAndTranslate("CUA", Translation.codonPatterns) should be(Some("Leu"))
  }

  it should "return 'Ile' if the Codon is 'AUU'" in {
    Translation.findAndTranslate("AUU", Translation.codonPatterns) should be(Some("Ile"))
  }

  it should "return 'Ile' if the Codon is 'AUC'" in {
    Translation.findAndTranslate("AUC", Translation.codonPatterns) should be(Some("Ile"))
  }

  it should "return 'Ile' if the Codon is 'AUA'" in {
    Translation.findAndTranslate("AUA", Translation.codonPatterns) should be(Some("Ile"))
  }

  it should "return 'Met' if the Codon is 'AUG'" in {
    Translation.findAndTranslate("AUG", Translation.codonPatterns) should be(Some("Met"))
  }

  it should "return 'Val' if the Codon starts with 'GU'" in {
    Translation.findAndTranslate("GUA", Translation.codonPatterns) should be(Some("Val"))
  }

  it should "return 'Ser' if the Codon starts with 'UC'" in {
    Translation.findAndTranslate("UCA", Translation.codonPatterns) should be(Some("Ser"))
  }

  it should "return 'Ser' if the Codon is 'AGU'" in {
    Translation.findAndTranslate("AGU", Translation.codonPatterns) should be(Some("Ser"))
  }

  it should "return 'Ser' if the Codon is 'AGC'" in {
    Translation.findAndTranslate("AGC", Translation.codonPatterns) should be(Some("Ser"))
  }

  it should "return 'Stop' if the Codon is 'UAA'" in {
    Translation.findAndTranslate("UAA", Translation.codonPatterns) should be(Some("Stop"))
  }

  it should "return 'Stop' if the Codon is 'UAG'" in {
    Translation.findAndTranslate("UAG", Translation.codonPatterns) should be(Some("Stop"))
  }

  it should "return 'Stop' if the Codon is 'UGA'" in {
    Translation.findAndTranslate("UGA", Translation.codonPatterns) should be(Some("Stop"))
  }

}
