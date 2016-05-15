package translate.dna

/**
  * Created by will on 14/05/16.
  */
object Translation {

  val pheRegex = "UU[UC]"
  val leuRegex = "CU.|UU[AG]"
  val metRegex = "AU."
  val serRegex = "UC.|AG."
  val stopRegex = "UA[AG]|UGA"

  def translateSequence(geneString: String) : String = {
    geneString.length match {
      case 3 => translateCodon(geneString)
      case len if len > 3 => translateCodon(geneString.take(3)) + translateSequence(geneString.drop(3))
      case _ => throw new RuntimeException("Gene sequence is too short")
    }
  }

  def translateCodon(codon: String) : String = {
    if(isPhe(codon)) "Phe"
    else if(isLeu(codon)) "Leu"
    else if(isIle(codon)) "Ile"
    else if(isMet(codon)) "Met"
    else if(isVal(codon)) "Val"
    else if(isSer(codon)) "Ser"
    else if(isStop(codon)) "Stop"
    else "Unknown"
  }

  private def isPhe(codon: String) : Boolean = codon.matches(pheRegex)

  private def isLeu(codon: String) : Boolean = codon.matches(leuRegex)

  private def isIle(codon: String) : Boolean = isMet(codon) && codon.last != 'G'

  private def isMet(codon: String) : Boolean = codon.matches(metRegex)

  private def isVal(codon: String) : Boolean = codon.startsWith("GU")

  private def isSer(codon: String) : Boolean = codon.matches(serRegex)

  private def isStop(codon: String) : Boolean = codon.matches(stopRegex)

}
