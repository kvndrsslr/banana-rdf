package org.w3.banana.jena

import org.w3.banana._
import com.hp.hpl.jena.sparql.core._

class JenaAsyncSparqlEngineTest() extends AsyncSparqlEngineTest()(
  JenaRDFReader.RDFXMLReader,
  JenaDiesel,
  JenaGraphIsomorphism,
  JenaSPARQLOperations,
  JenaStore(DatasetGraphFactory.createMem()))
