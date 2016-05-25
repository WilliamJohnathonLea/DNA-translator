package translate.dna

import scala.annotation.tailrec

/**
  * Created by will on 14/05/16.
  */
object Translation {

  val codonPatterns = List(
    "UU[UC]" -> "Phe",
    "CU.|UU[AG]" -> "Leu",
    "AUG" -> "Met",
    "AU[UCA]" -> "Ile",
    "GU." -> "Val",
    "UC.|AG." -> "Ser",
    "UA[AG]|UGA" -> "Stop"
  )

  def main(args: Array[String]) : Unit = args.length match {
    case 1 => println(translateSequence(args(0)))
    case _ => println("ERROR: You need to pass one argument to this program which contains the gene sequence you want to translate")
  }

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
      case _ => accStr
    }
  }

}
