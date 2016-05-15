package translate.dna

/**
  * Created by will on 14/05/16.
  */
class TranslationSpec extends TestBase {

  "Translation#translateCodon" should "return 'Phe' if the Codon is 'UUU'" in {
    Translation.translateCodon("UUU") should be("Phe")
  }

  it should "return 'Phe' if the Codon is 'UUC'" in {
    Translation.translateCodon("UUC") should be("Phe")
  }

  it should "return 'Leu' if the Codon is 'UUA'" in {
    Translation.translateCodon("UUA") should be("Leu")
  }

  it should "return 'Leu' if the Codon is 'UUG'" in {
    Translation.translateCodon("UUG") should be("Leu")
  }

  it should "return 'Leu' if the Codon starts with 'CU'" in {
    Translation.translateCodon("CUA") should be("Leu")
  }

  it should "return 'Ile' if the Codon is 'AUU'" in {
    Translation.translateCodon("AUU") should be("Ile")
  }

  it should "return 'Ile' if the Codon is 'AUC'" in {
    Translation.translateCodon("AUC") should be("Ile")
  }

  it should "return 'Ile' if the Codon is 'AUA'" in {
    Translation.translateCodon("AUA") should be("Ile")
  }

  it should "return 'Met' if the Codon is 'AUG'" in {
    Translation.translateCodon("AUG") should be("Met")
  }

  it should "return 'Val' if the Codon starts with 'GU'" in {
    Translation.translateCodon("GUA") should be("Val")
  }

  it should "return 'Ser' if the Codon starts with 'UC'" in {
    Translation.translateCodon("UCA") should be("Ser")
  }

  it should "return 'Ser' if the Codon is 'AGU'" in {
    Translation.translateCodon("AGU") should be("Ser")
  }

  it should "return 'Ser' if the Codon is 'AGC'" in {
    Translation.translateCodon("AGC") should be("Ser")
  }
//
//  it should "return 'Pro' if the Codon is 'CC'" in {
//
//  }
//
//  it should "return 'Thr' if the Codon is 'AC'" in {
//
//  }
//
//  it should "return 'Ala' if the Codon is 'GC'" in {
//
//  }
//
//  it should "return 'Tyr' if the Codon is 'UAU'" in {
//
//  }
//
//  it should "return 'Tyr' if the Codon is 'UAC'" in {
//
//  }
//
  it should "return 'Stop' if the Codon is 'UAA'" in {
    Translation.translateCodon("UAA") should be("Stop")
  }

  it should "return 'Stop' if the Codon is 'UAG'" in {
    Translation.translateCodon("UAG") should be("Stop")
  }

  it should "return 'Stop' if the Codon is 'UGA'" in {
    Translation.translateCodon("UGA") should be("Stop")
  }
//
//  it should "return 'His' if the Codon is 'CAU'" in {
//
//  }
//
//  it should "return 'His' if the Codon is 'CAC'" in {
//
//  }
//
//  it should "return 'Glm' if the Codon is 'CAA'" in {
//
//  }
//
//  it should "return 'Glm' if the Codon is 'CAG'" in {
//
//  }
//
//  it should "return 'Asn' if the Codon is 'AAU'" in {
//
//  }
//
//  it should "return 'Asn' if the Codon is 'AAC'" in {
//
//  }
//
//  it should "return 'Lys' if the Codon is 'AAA'" in {
//
//  }
//
//  it should "return 'Lys' if the Codon is 'AAG'" in {
//
//  }
//
//  it should "return 'Asp' if the Codon is 'GAU'" in {
//
//  }
//
//  it should "return 'Asp' if the Codon is 'GAC'" in {
//
//  }
//
//  it should "return 'Glu' if the Codon is 'GAA'" in {
//
//  }
//
//  it should "return 'Glu' if the Codon is 'GAG'" in {
//
//  }
//
//  it should "return 'Trp' if the Codon is 'UGG'" in {
//
//  }
//
//  it should "return 'Arg' if the Codon is 'CG'" in {
//
//  }
//
//  it should "return 'Arg' if the Codon is 'AGA'" in {
//
//  }
//
//  it should "return 'Arg' if the Codon is 'AGG'" in {
//
//  }
//
//  it should "return 'Gly' if the Codon is 'GG'" in {
//
//  }

}
