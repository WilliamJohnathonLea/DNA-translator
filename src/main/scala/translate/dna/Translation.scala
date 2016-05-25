package translate.dna

import scala.annotation.tailrec

/**
  * Created by will on 14/05/16.
  */
object Translation {

  val pheRegex = "UU[UC]"
  val leuRegex = "CU.|UU[AG]"
  val metRegex = "AUG"
  val ileRegex = "AU[UCA]"
  val valRegex = "GU."
  val serRegex = "UC.|AG."
  val stopRegex = "UA[AG]|UGA"

  val codonPatterns = List(
    pheRegex -> "Phe",
    leuRegex -> "Leu",
    metRegex -> "Met",
    ileRegex -> "Ile",
    valRegex -> "Val",
    serRegex -> "Ser",
    stopRegex -> "Stop"
  )

  @tailrec
  def findAndTranslate(codon: String, patternList: List[(String, String)] = codonPatterns) : Option[String] = {
    if(patternList.isEmpty) None
    else if(codon matches patternList.head._1) Some(patternList.head._2)
    else findAndTranslate(codon, patternList.tail)
  }

  @tailrec
  def translateSequence(geneString: String, accStr: String = "") : String = {
    geneString.length match {
      case 3 => findAndTranslate(geneString).fold("")(tc => accStr + tc) // tc = translated codon
      case len if len > 3 =>
        translateSequence(geneString.drop(3), accStr + findAndTranslate(geneString.take(3)).fold("")(tc => tc))
      case _ => ""
    }
  }

}
