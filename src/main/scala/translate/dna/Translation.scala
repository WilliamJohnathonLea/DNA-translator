package translate.dna

/**
  * Created by will on 14/05/16.
  */
object Translation {

  def translateCodon(codon: String) : String = {
    if(isPhe(codon)) "Phe"
    else if(isLeu(codon)) "Leu"
    else if(isIle(codon)) "Ile"
    else if(isMet(codon)) "Met"
    else "Val"
  }

  private def isPhe(codon: String) : Boolean = codon.startsWith("UU") && (codon.last == 'U' || codon.last == 'C')

  private def isLeu(codon: String) : Boolean = codon.startsWith("CU") || codon.startsWith("UU") && (codon.last == 'A' || codon.last == 'G')

  private def isIle(codon: String) : Boolean = isMet(codon) && codon.last != 'G'

  private def isMet(codon: String) : Boolean = codon.startsWith("AU")

}
