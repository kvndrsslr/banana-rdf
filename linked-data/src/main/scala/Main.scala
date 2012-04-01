package org.w3.linkeddata

import org.w3.rdf._
import org.w3.rdf.sesame._
import org.w3.rdf.jena._

object Main {

  def main(args: Array[String]): Unit = {

    //    import SesameOperations._
    //    
    //    val ld = new LinkedData(SesameOperations, SesameProjections, SesameRDFUtils, SesameTurtleReader, SesameTurtleWriter)

    import JenaOperations._

    val ld = LinkedData.inMemoryImpl(JenaOperations, JenaProjections, JenaRDFUtils, JenaReaderFactory)
    import ld._

//    val namesLD = for {
//      barack ← goto(IRI("http://dbpedia.org/resource/Barack_Obama"))
//      family ← barack.follow(IRI("http://dbpedia.org/ontology/child"))
//      members ← family.follow(IRI("http://dbpedia.org/property/members"))
//      names ← members.follow(IRI("http://dbpedia.org/property/name")).asStrings
//    } yield names
//
//    val names = namesLD.timbl()
//
//    println(names)




    val cert = prefixBuilder("http://www.w3.org/ns/auth/cert#") _
    val foaf = prefixBuilder("http://xmlns.com/foaf/0.1/") _

    val resultLD = for {
      bblfish ← goto(IRI("http://bblfish.net/people/henry/card#me"))
      people ← bblfish.follow(foaf("knows")).follow(foaf("name")).asStrings
    } yield people

    val result = resultLD.timbl()

    println(result)

    ld.shutdown()

  }

}