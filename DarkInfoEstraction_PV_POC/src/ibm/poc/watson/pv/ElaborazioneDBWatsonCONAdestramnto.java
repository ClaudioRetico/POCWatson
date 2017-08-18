package ibm.poc.watson.pv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class ElaborazioneDBWatsonCONAdestramnto {

	private static NaturalLanguageUnderstanding service;
	private static Features features;
	private static Connection dbconn;
	private static final String sqltxt = "SELECT CASE_ID, TEXT FROM DASH13540.POC_MAININPUTVIEW_SI_LEARNING";
	private static final String sqlinsert = "INSERT INTO DASH13540.\"POC_ResultSILEARNING\" (\"Case ID\", \"PrimaKeyword\", \"SecondaKeyword\", \"TerzaKeyword\", \"RelevancePrimaKeyword\", \"RelevanceSecondaKeyword\", \"RelevanceTerzaKeyword\", \"PrimaCategory\", \"SecondaCategory\", \"TerzaCategory\", \"RelevancePrimaCategory\", \"RelevanceSecondaCategory\", \"RelevanceTerzaaCategory\", \"DocumentSentiment\", \"MillisecElaborazioneWatson\") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String PrimaKeyword = "";
	private static String SecondaKeyword = "";
	private static String TerzaKeyword = "";
	private static Double RelevancePrimaKeyword = (double) 0;
	private static Double RelevanceSecondaKeyword = (double) 0;
	private static Double RelevanceTerzaKeyword = (double) 0;
	private static String PrimaCategory = "";
	private static String SecondaCategory = "";
	private static String TerzaCategory = "";
	private static Double RelevancePrimaCategory = (double) 0;
	private static Double RelevanceSecondaCategory = (double) 0;
	private static Double RelevanceTerzaCategory = (double) 0;
	private static Double DocumentSentiment = (double) 0;

	public static void main(String[] args) {

		initwatson();
		initdb();
		try {
			PreparedStatement theSQLStatement = dbconn.prepareStatement(sqltxt);
			PreparedStatement theSQLInsert = dbconn.prepareStatement(sqlinsert);

			ResultSet rs = theSQLStatement.executeQuery();
			while (rs.next()) {
				long startTime = System.currentTimeMillis();
				AnalysisResults response = watsonanalisi(rs.getString("TEXT").replaceAll("_", ""), service, features);
				long endTime = System.currentTimeMillis();
				long millisecondsDuration = (endTime - startTime);

				System.out.println(rs.getString("TEXT"));
				System.out.println(response);
				System.out.println(millisecondsDuration);

				parseResponse(response);
				
				scriviRisultato(theSQLInsert,rs.getInt("CASE_ID"), millisecondsDuration);

			}
			;
			rs.close();
			dbconn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				dbconn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private static void initwatson() {
		service = new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
				"f1f3adf3-ad1d-4fd3-ae9b-7b284f26e858", "FmdO61U1LpWn");
		EntitiesOptions entitiesOptions = new EntitiesOptions.Builder().emotion(true).sentiment(true).limit(3).model("10:d2b034f8-8dfc-4976-bf73-3cbba2d6dc36").build();
		KeywordsOptions keywordsOptions = new KeywordsOptions.Builder().emotion(true).sentiment(true).limit(3).build();
		ConceptsOptions conceptOptions = new ConceptsOptions.Builder().limit(3).build();
		CategoriesOptions categoryOptions = new CategoriesOptions();
		RelationsOptions relations = new RelationsOptions.Builder().model("10:d2b034f8-8dfc-4976-bf73-3cbba2d6dc36").build();
		SemanticRolesOptions semanticRoles = new SemanticRolesOptions.Builder().build();
		SentimentOptions sentiment = new SentimentOptions.Builder().build();
		features = new Features.Builder().entities(entitiesOptions).keywords(keywordsOptions).concepts(conceptOptions)
				.categories(categoryOptions).relations(relations).semanticRoles(semanticRoles).sentiment(sentiment)
				.build();

	}

	private static void initdb() {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			dbconn = DriverManager.getConnection(
					"jdbc:db2://dashdb-entry-yp-dal09-10.services.dal.bluemix.net:50000/BLUDB", "dash13540",
					"Ah6tsLL@T2f@");
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

	private static void parseResponse(AnalysisResults response) {
		List<KeywordsResult> ks = response.getKeywords();
		int nkeyw = ks.size();
		if (nkeyw > 0) {
			PrimaKeyword = ks.get(0).getText();
			RelevancePrimaKeyword = ks.get(0).getRelevance();
		}
		if (nkeyw > 1) {
			SecondaKeyword = ks.get(1).getText();
			RelevanceSecondaKeyword = ks.get(1).getRelevance();
		}
		if (nkeyw > 2) {
			TerzaKeyword = ks.get(2).getText();
			RelevanceTerzaKeyword = ks.get(2).getRelevance();
		}

		List<CategoriesResult> cat = response.getCategories();
		int ncat = cat.size();
		if (ncat > 0) {
			PrimaCategory = cat.get(0).getLabel();
			RelevancePrimaCategory = cat.get(0).getScore();
		}
		if (ncat > 1) {
			SecondaCategory = cat.get(1).getLabel();
			RelevanceSecondaCategory = cat.get(1).getScore();
		}
		if (ncat > 2) {
			TerzaCategory = cat.get(2).getLabel();
			RelevanceTerzaCategory = cat.get(2).getScore();
		}

		DocumentSentiment = response.getSentiment().getDocument().getScore();

	}
	
	private static void scriviRisultato(PreparedStatement theInsert, int caseId, long duration) {
		
		
		try {
			theInsert.setInt(1, caseId);
			theInsert.setString(2, PrimaKeyword);
			theInsert.setString(3, SecondaKeyword);			
			theInsert.setString(4, TerzaKeyword);
			theInsert.setDouble(5, RelevancePrimaKeyword.doubleValue());
			theInsert.setDouble(6, RelevanceSecondaKeyword.doubleValue());			
			theInsert.setDouble(7, RelevanceTerzaKeyword.doubleValue());	
			theInsert.setString(8, PrimaCategory);
			theInsert.setString(9, SecondaCategory);			
			theInsert.setString(10, TerzaCategory);
			theInsert.setDouble(11, RelevancePrimaCategory.doubleValue());
			theInsert.setDouble(12, RelevanceSecondaCategory.doubleValue());			
			theInsert.setDouble(13, RelevanceTerzaCategory.doubleValue());	
			theInsert.setDouble(14, DocumentSentiment.doubleValue());	
			theInsert.setInt(15, (int) duration);	
			theInsert.execute();
			dbconn.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
	}

}
