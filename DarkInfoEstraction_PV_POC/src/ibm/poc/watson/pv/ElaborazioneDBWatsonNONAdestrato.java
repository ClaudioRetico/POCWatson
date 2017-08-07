package ibm.poc.watson.pv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;


public class ElaborazioneDBWatsonNONAdestrato {

	private static NaturalLanguageUnderstanding service;
	private static Features features;
	private static Connection dbconn;

	public static void main(String[] args) {
		
		final String text = "Risposta Definitiva 09.08.2016          09:33:19            BRUSCOL4 si chiude come da disposizioni ____________________ Risposta in Lavorazione Caso 08.08.2016          12:33:27            SIMONELLI l'up deve inviare a poste vita comunicazione chiara di quanto accaduto ____________________ Risposta in Lavorazione Caso 04.01.2016          10:07:49            SAVIROB1 pratica espressamente aperta su richiesta insistita di ops di up ops di up e contraente assicurata di polizza ad hoc scaduta ops di up dichiara di non aver ricevuto assistenza adeguata in precedenza dal servizio e di aver parlato con due operatrici di sesso femminile, di cui ricorda e segnala il nome di una, francesca inizialmente aveva richiesto possibilita di reinvestimento reimpiegando la somma a scadenza con possibilita di emettere 2 polizze fedelta ha ricevuto un'assistenza inadeguata, ricevendo prima informazione di possibilita di emissione di 2 polizze fedelta, mentre da una polizza in scadenza e possibile emettere soltanto 1 polizza fedelta inoltre ha ricevuto anche l'informazione che effettuando l'attivita della -revoca- avrebbe poi, richiedendo il pagamento della liquidazione, dalla ricezione del pagamento avrebbe potuto emettere comunque la polizza di reinvestimento fedelta; informata che l'attivita di -revoca- fa rinunciare alla possibilita del reimpiego, del reinvestimento ops di up allo stato attuale richiede risposta in forma scritta da parte di ufficio di compagnia sulla possibilita, visto che il reimpiego che aveva richiesto era di un importo parziale della somma a scadenza, di 2'000 euro su di una liquidazione per scadenza lorda di euro 5'358,88, di reinvestire dalla ricezione del pagamento della liquidazione almeno un parziale al netto della somma di 2'000 euro del reivestimento iniziale poi revocato. ops di up ora richiede risposta in forma scritta anche per mezzo mail UTO1536DIR@posteitaliane.it prego poter verificare, grazie ____________________ Richieste cliente 04.01.2016          10:07:48            SAVIROB1 pratica espressamente aperta su richiesta insistita di ops di up ops di up e contraente assicurata di polizza ad hoc scaduta ops di up dichiara di non aver ricevuto assistenza adeguata in precedenza dal servizio e di aver parlato con due operatrici di sesso femminile, di cui ricorda e segnala il nome di una, francesca inizialmente aveva richiesto possibilita di reinvestimento reimpiegando la somma a scadenza con possibilita di emettere 2 polizze fedelta ha ricevuto un'assistenza inadeguata, ricevendo prima informazione di possibilita di emissione di 2 polizze fedelta, mentre da una polizza in scadenza e possibile emettere soltanto 1 polizza fedelta inoltre ha ricevuto anche l'informazione che effettuando l'attivita della -revoca- avrebbe poi, richiedendo il pagamento della liquidazione, dalla ricezione del pagamento avrebbe potuto emettere comunque la polizza di reinvestimento fedelta; informata che l'attivita di -revoca- fa rinunciare alla possibilita del reimpiego, del reinvestimento ops di up allo stato attuale richiede risposta in forma scritta da parte di ufficio di compagnia sulla possibilita, visto che il reimpiego che aveva richiesto era di un importo parziale della somma a scadenza, di 2'000 euro su di una liquidazione per scadenza lorda di euro 5'358,88, di reinvestire dalla ricezione del pagamento della liquidazione almeno un parziale al netto della somma di 2'000 euro del reivestimento iniziale poi revocato. ops di up ora richiede r";

        initwatson();
        initdb();

       
        long startTime = System.currentTimeMillis();
        AnalysisResults response= watsonanalisi(text, service, features);
        long endTime = System.currentTimeMillis();
        long millisecondsDuration = (endTime - startTime);
		
		//Parse della response
		List<KeywordsResult> ks = response.getKeywords();
		String PrimaKeyword = ks.get(0).getText();
		String SecondaKeyword = ks.get(1).getText();
		String TerzaKeyword = ks.get(2).getText();
		Double RelevancePrimaKeyword = ks.get(0).getRelevance();
		Double RelevanceSecondaKeyword = ks.get(1).getRelevance();
		Double RelevanceTerzaKeyword = ks.get(2).getRelevance();
		
		List<CategoriesResult> cat = response.getCategories();
		String PrimaCategory = cat.get(0).getLabel();
		String SecondaCategory = cat.get(1).getLabel();
		String TerzaCategory = cat.get(2).getLabel();
		Double RelevancePrimaCategory = cat.get(0).getScore();
		Double RelevanceSecondaCategory = cat.get(1).getScore();
		Double RelevanceTerzaCategory = cat.get(2).getScore();
		
		Double DocumentSentiment  = response.getSentiment().getDocument().getScore();
					
		
		System.out.println(response);
		System.out.println(millisecondsDuration);
	}
	
	private static void initwatson() {
		 service = new NaturalLanguageUnderstanding(
				NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27, "f1f3adf3-ad1d-4fd3-ae9b-7b284f26e858",
				"FmdO61U1LpWn");
		EntitiesOptions entitiesOptions = new EntitiesOptions.Builder().emotion(true).sentiment(true).limit(3).build();
		KeywordsOptions keywordsOptions = new KeywordsOptions.Builder().emotion(true).sentiment(true).limit(3).build();
		ConceptsOptions conceptOptions = new ConceptsOptions.Builder().limit(3).build();
		CategoriesOptions  categoryOptions = new CategoriesOptions();
		RelationsOptions relations = new RelationsOptions.Builder().build();
		SemanticRolesOptions semanticRoles = new SemanticRolesOptions.Builder().build();
        SentimentOptions sentiment = new SentimentOptions.Builder().build();
		features = new Features.Builder()
				.entities(entitiesOptions)
				.keywords(keywordsOptions)
				.concepts(conceptOptions)
				.categories(categoryOptions)
				.relations(relations)
				.semanticRoles(semanticRoles)
				.sentiment(sentiment)
				.build();

		
	}
	
	private static void initdb() {
        try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			dbconn = DriverManager.getConnection ("jdbc:db2://dashdb-entry-yp-dal09-10.services.dal.bluemix.net:50000/BLUDB", "dash13540", "Ah6tsLL@T2f@");
			dbconn.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static AnalysisResults watsonanalisi(String text, NaturalLanguageUnderstanding service, Features features) {
				
		AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(text).features(features).build();
		return service.analyze(parameters).execute();
	}

}
