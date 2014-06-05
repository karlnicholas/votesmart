package examples;

import org.votesmart.api.VoteSmart;
import org.votesmart.api.VoteSmartErrorException;
import org.votesmart.classes.*;
import org.votesmart.data.*;

/**
 * <pre> 
 * This program is a very simple demonstration of this RESTful Client API.
 * It requires a ResourceBundle named VoteSmart. This means a file
 * named VoteSmart.properties must be found in your class path, such
 * as your resources directory. This VoteSmart client reads three 
 * keys from the resource bundle, two of which are mandatory.
 * These are in the form of key=value, one on each line.
 * The three keys are:
 * 
 * apikey    (Mandatory) get from VoteSmart.org
 * cache     (Mandatory) such as c:/tmp/VoteSmartCache
 * 
 * The basic goal here are to make (most) every possible call 
 * and use ID's from earlier calls to pass to later calls.
 * 
 * The queries will be cached and all subsequent calls will return 
 * the same information. If you want to disable the cache checking, 
 * then call VoteSmart.checkCache(false); or VoteSmart.checkCache(true);
 * to turn it back on.
 * 
 * Secondarily, the goal is to list make all the calls that can be 
 * made for a state.
 * </pre>
 *
 */
public class AllThingsMissouri {

	public static void handleError(VoteSmartErrorException e) {
		System.out.println("Error: " + e.errorBase.errorMessage);
		System.out.println("	Details: " + e.method + " " + e.argMap + "\n");
	}

	public static void main(String... args) throws Exception {
		// put a votesmart.properties file in the /src/main/resources directory
		// There is an sample one there now (votesmartsample.properties)
		// put your VoteSmart API key in it and set a caching directory, 
		// then rename it to (votesmart.properties).
		
		// Get general Information about offices
		OfficeClass officeClass = new OfficeClass();
		
		// get Office.getBranches
		Branches branches = officeClass.getBranches();
		System.out.println("There are " + branches.branch.size() + " branches");
		Branches.Branch officeBranch = branches.branch.get(1);
		System.out.println("The second branchId is " + officeBranch.officeBranchId + ", called " + officeBranch.name +"\n" );
		
		// Office.getTypes
		OfficeTypes officeTypes = officeClass.getTypes();
		System.out.println("There are " + officeTypes.type.size() + " types");
		OfficeTypes.Type officeType  = officeTypes.type.get(5);
		System.out.println("The fifth officeTypeId is " + officeType.officeTypeId + ", called " + officeType.name +"\n" );
		
		// Office.getLevels
		Levels levels = officeClass.getLevels();
		System.out.println("There are " + levels.level.size() + " levels");
		Levels.Level officeLevel = levels.level.get(1);
		System.out.println("The second officeLevelId is " + officeLevel.officeLevelId + ", called " + officeLevel.name +"\n" );

		// Office getOfficesByLevel
		Offices offices = officeClass.getOfficesByLevel(officeLevel.officeLevelId);
		System.out.println("There are " + offices.office.size() + " offices for Level " + officeLevel.name );

		// Office getOfficesByType
		offices = officeClass.getOfficesByType(officeType.officeTypeId);
		System.out.println("There are " + offices.office.size() + " offices for the Type " + officeType.name +"\n");

		// Hold office information for later use.
		Offices.Office office;
		
		// Office getOfficesByTypeLevel
		offices = officeClass.getOfficesByTypeLevel(officeType.officeTypeId, officeLevel.officeLevelId);
		System.out.println("There are " + offices.office.size() + " offices for the Type/Level " + officeType.name+ "/" + officeLevel.name);
		office = offices.office.get(0);
		System.out.println("The officeId for Type/Level is " + office.officeId + ", and is called " + office.name +"\n" );

		// Office getOfficesByBranchLevel
		offices = officeClass.getOfficesByBranchLevel(officeBranch.officeBranchId, officeLevel.officeLevelId);
		System.out.println("There are " + offices.office.size() + " offices for the Branch/Level " + officeBranch.name + "/" + officeLevel.name );
		office = offices.office.get(1);
		System.out.println("The second officeId for Type is " + office.officeId + ", and is called " + office.name +"\n" );
		
		// Determine Missouri State Id
		StateClass stateClass = new StateClass();
		StateList allStates = stateClass.getStateIDs();
		StateList.List.State state = null;
		for( StateList.List.State aState: allStates.list.state ) {
			if (aState.name.equals("Missouri")) {
				System.out.println("The stateId for Missouri is " + aState.stateId + "\n");
				state = aState;
				break;
			}
		}
		// Get State Details
		State stateDetail = stateClass.getState(state.stateId);
		System.out.println("Missouri has " + stateDetail.details.area);
		System.out.println("The state bird is the " + stateDetail.details.bird );
		System.out.println("Missouri's bicameral flag is set to " + stateDetail.details.bicameral + "\n");
		

		// Officials
		OfficialsClass officialsClass = new OfficialsClass();

		// Officials		
		CandidateList candidates = officialsClass.getStatewide();
		System.out.println("There are a total of " + candidates.candidate.size() + " officials (No State Specified)" + "\n");
		
		// Officials for CA
		candidates = officialsClass.getStatewide(state.stateId);
		System.out.println("There are a total of " + candidates.candidate.size() + " officials in " + state.name );
		CandidateList.Candidate candidate = candidates.candidate.get(0);
		System.out.println("The first candidateId is " + candidate.candidateId + ", called " + candidate.firstName + " " + candidate.lastName + "\n" );
		
		// Officials for last officeType (Legislature), for state
		candidates = officialsClass.getByOfficeTypeState(officeType.officeTypeId, state.stateId);
		System.out.println("There are a total of " + candidates.candidate.size() + " officials for officeType " + officeType.officeTypeId + " in "+ state.name );
		candidate = candidates.candidate.get(0);
		System.out.println("The first candidateId is " + candidate.candidateId + ", called " + candidate.firstName + " " + candidate.lastName + "\n" );

		// Officials for last office (State Assembly), for state
		candidates = officialsClass.getByOfficeState(office.officeId, state.stateId);
		System.out.println("There are a total of " + candidates.candidate.size() + " officials for office " + office.name + " in "+ state.name + "\n" );

		CandidatesClass candidatesClass = new CandidatesClass();
		// Candidates for last office, for state
		candidates = candidatesClass.getByOfficeState(office.officeId, state.stateId);
		System.out.println("There are a total of " + candidates.candidate.size() + " candidates for office " + office.name + " in "+ state.name + "\n" );


		// Candidates for last office, for state
		candidates = candidatesClass.getByOfficeTypeState(officeType.officeTypeId, state.stateId);
		System.out.println("There are a total of " + candidates.candidate.size() + " candidates for officeType " + officeType.officeTypeId + " in "+ state.name + "\n" );

		try {
			CandidateList candidatesByLastName = candidatesClass.getByLastname(candidate.lastName);
			System.out.println("There are " + candidatesByLastName.candidate.size() + " candidates with lastName of " + candidate.lastName + "\n"  );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		try {
			CandidateList candidatesByLastName = candidatesClass.getByLevenshtein(candidate.lastName);
			System.out.println("There are " + candidatesByLastName.candidate.size() + " candidates with lastName of " + candidate.lastName + "\n"  );
		} catch (VoteSmartErrorException e) { handleError(e); }

		// Addresses of  
		AddressClass addressClass = new AddressClass();
		
		// address of Office (State Assembly)
		AddressAddress addressOffice = addressClass.getOfficeByOfficeState(office.officeId, state.stateId);
		System.out.println("There are " + addressOffice.office.size() + " addresses for " + office.name + " in " + state.name  );
		System.out.println("First address is " + addressOffice.office.get(0).address.street + ", " + addressOffice.office.get(0).address.city + ", " + addressOffice.office.get(0).address.state + " " + addressOffice.office.get(0).address.zip + "\n");
		
		// address of Official
		AddressOffice addressOffical = addressClass.getOffice(candidate.candidateId);
		System.out.println("There are " + addressOffical.office.size() + " addresses for " + candidate.firstName + " " + candidate.lastName  );
		System.out.println("First address for " + candidate.firstName + " " + candidate.lastName + " is " + addressOffical.office.get(0).address.street + ", " + addressOffical.office.get(0).address.city + ", " + addressOffical.office.get(0).address.state + " " + addressOffical.office.get(0).address.zip + "\n");

		// WebAddress of Official
		WebAddress webAddressOffical = addressClass.getOfficeWebAddress(candidate.candidateId);
		System.out.println("There are " + webAddressOffical.address.size() + " addresses for " + candidate.firstName + " " + candidate.lastName  );
		System.out.println("First address for " + candidate.firstName + " " + candidate.lastName + " is " + webAddressOffical.address.get(0).webAddress + "\n");
		
		// Candidate biographical 
		CandidateBioClass candidateBioClass = new CandidateBioClass();
		
		// Bio of Official
		Bio bio = candidateBioClass.getBio(candidate.candidateId);
		System.out.println( "Bio for " + bio.candidate.firstName + " " + bio.candidate.lastName + " includes:");
		System.out.println( "	Birthdate: \t" + bio.candidate.birthDate );
		System.out.println( "	Birthplace: \t" + bio.candidate.birthPlace );
		System.out.println( "	Gender: \t" + bio.candidate.gender );
		System.out.println( "	Education: \t" + bio.candidate.education );
		System.out.println( "	Profession: \t" + bio.candidate.profession );
		System.out.println( "	Religion: \t" + bio.candidate.religion );
		System.out.println( "Number of Committees is " + bio.office.committee.size() );
		System.out.println( "First Committee is " + bio.office.committee.get(0).committeeName + "\n");
		
		// save committee for later
		Bio.Office.Committee committeeByBio = bio.office.committee.get(0);
		
		try {
			AddlBio addlBio = candidateBioClass.getAddlBio(candidate.candidateId);
			System.out.println( "AddlBio for " + addlBio.candidate.firstName + " " + addlBio.candidate.lastName + " includes:");
			System.out.println( "	Profession: \t" + addlBio.additional.item.size() + " items");
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		// Committee class
		CommitteeClass committeeClass = new CommitteeClass();

		Committee committee = committeeClass.getCommittee(committeeByBio.committeeId);
		System.out.println("Committee details for " + committee.name);
		System.out.println("	Jurisdiction:" + committee.jurisdiction);
		System.out.println("	committeeTypeId:" + committee.committeeTypeId + "\n");

		CommitteeTypes committeeTypes = committeeClass.getTypes();
		System.out.println("There are " + committeeTypes.type.size() + " committee types in total \n");
		// save committeeType for later
		CommitteeTypes.Type committeeType = null;
		for (CommitteeTypes.Type searchType:  committeeTypes.type ) {
			if (searchType.committeeTypeId.equals(committee.committeeTypeId) ) {
				committeeType = searchType;
				break;
			}
		}
		System.out.println("The comitteeType for " + committeeType.committeeTypeId + " is called " + committeeType.name +"\n" );

		// CommitteeMembers class
		CommitteeMembers committeeMembers = committeeClass.getCommitteeMembers(committee.committeeId); 
		System.out.println("There are " + committeeMembers.member.size() + " members in committee " + committee.name + "\n"); 

		// Committees class
		Committees committees = committeeClass.getCommitteesByTypeState(committeeType.committeeTypeId, state.stateId);
		System.out.println("There are " + committees.committee.size() + " committees of type " + committeeType.name + " in " + state.name + "\n");
		
		// Leadership class
		LeadershipClass leadershipClass = new LeadershipClass();
		Leadership leadership = leadershipClass.getPositions();
		System.out.println("There are " + leadership.position.size() + " leadership positions total \n");
		
		// all positions
		leadership = leadershipClass.getPositions(state.stateId);
		System.out.println("There are " + leadership.position.size() + " leadership positions in " + state.name);

		// all positions for office in state
		leadership = leadershipClass.getPositions(state.stateId, office.officeId);
		System.out.println("There are " + leadership.position.size() + " leadership positions for office " + office.name + " in " + state.name);
		Leadership.Position position = leadership.position.get(0);
		System.out.println("The first leadershipId is " + position.leadershipId + ", called " + position.name + "\n" );

		// oficials for this position in state
		Leaders leaders = leadershipClass.getOfficials(position.leadershipId, state.stateId);
		System.out.println("There are " + leaders.leader.size() + " leaders for position " + position.name + " in " + state.name);
		Leaders.Leader leader = leaders.leader.get(0);
		System.out.println("The first leader candidateId is " + leader.candidateId + ", the leader is " + leader.firstName + " " + leader.lastName + "\n" );
		
		// Npat class
		NpatClass npatClass = new NpatClass();
		// Npat if it exists
		Npat npat = npatClass.getNpat(leader.candidateId);
		System.out.println("Npat survey message for leader " + candidate.ballotName + " is " + npat.surveyMessage + "\n");
		
		// Rating class
		RatingClass ratingClass = new RatingClass();
		// all categories
		Categories categories = ratingClass.getCategories();
		System.out.println("There are " + categories.category.size() + " categories total \n");
		
		// state categories
		categories = ratingClass.getCategories(state.stateId);
		System.out.println("There are " + categories.category.size() + " categories in " + state.name + "\n");
		CategoryMin category = categories.category.get(0);
		System.out.println("The first categoryId is " + category.categoryId );
		
		// state sigs (Special Interest Groups)
		Sigs sigs = ratingClass.getSigList(category.categoryId, state.stateId);
		System.out.println("There are " + sigs.sig.size() + " sigs for category " + category.name + " in " + state.name + "\n");
		Sigs.Sig sigsSig = sigs.sig.get(0);
		System.out.println("The first sigId is " + sigsSig.sigId + ", called " + sigsSig.name + "\n" );
		
		// Sig
		Sig sig = ratingClass.getSig(sigs.sig.get(0).sigId);
		System.out.println("Description for sigId " + sig.sigId + " is " + sig.description);
		System.out.println("	Address is " + sig.address + "\n");
		
		// SigRatings
		SigRating sigRatings = ratingClass.getSigRatings(sig.sigId);
		System.out.println("There are " + sigRatings.rating.size() + " ratings for sig " + sigRatings.sig.name+ "\n");
		SigRating.Rating sigRating = sigRatings.rating.get(0);
		System.out.println("The first ratingId is " + sigRating.ratingId + ", called " + sigRating.ratingName + "\n");

		// Sig ratings for Candidate
		CandidateRating candidateRating = ratingClass.getCandidateRating(leader.candidateId);
		System.out.println("There are " + candidateRating.rating.size() + " ratings for leader " + leader.firstName + " " + leader.lastName + "\n");
		
		// Rating done by SIG group
		Rating rating = ratingClass.getRating(sigRating.ratingId);
		System.out.println("There are " + rating.candidateRating.size() + " candidate ratings for ratingId " + sigRating.ratingId);
		Rating.CandidateRating ratingCandidateRating = rating.candidateRating.get(0);
		System.out.println("The Rating for canididateId " + ratingCandidateRating.candidateId + " is " + ratingCandidateRating.rating +"\n");
		
		// Votes class
		VotesClass votesClass = new VotesClass();
		
		// total votesCategories
		VotesCategories votesCategories = votesClass.getCategories("2013");
		System.out.println("There are " + votesCategories.category.size() + " in total in 2013\n");		
		
		// for CA
		votesCategories = votesClass.getCategories("2013", state.stateId);
		System.out.println("There are " + votesCategories.category.size() + " votes categories for " + state.name + " in 2013\n");
		CategoryMin votesCategory = votesCategories.category.get(0); 
		System.out.println("The first categoryId is " + votesCategory.categoryId + ", called " + votesCategory.name + "\n");

		// for category, for 2013, for CA
		Bills bills = votesClass.getBillsByCategoryYearState(votesCategory.categoryId, "2013", state.stateId);
		System.out.println("There are " + bills.bill.size() + " bills for category " + votesCategory.name + " in 2013 in "+ state.name + " \n");

		// by Official, Category, Office
		bills = votesClass.getBillsByOfficialCategoryOffice(leader.candidateId, votesCategory.categoryId);
		System.out.println("There are " + bills.bill.size() + " bills for leader " + leader.firstName + " " + leader.lastName + " in 2013 in "+ state.name + " \n");

		// by Official, Year, Office
		bills = votesClass.getBillsByOfficialYearOffice(candidate.candidateId, "2013", office.officeId);
		System.out.println("There are " + bills.bill.size() + " bills for candidate " + candidate.firstName + " " + candidate.lastName + " in 2013 in "+ office.name + " \n");

		// by Official, Category, Office
		bills = votesClass.getBillsByOfficialCategoryOffice(candidate.candidateId, votesCategory.categoryId, office.officeId);
		System.out.println("There are " + bills.bill.size() + " bills for candidate " + candidate.firstName + " " + candidate.lastName + " for " + votesCategory.name + " in "+ office.name + " \n");
		System.out.println("The first billId is " + bills.bill.get(0).billId + ", titled " + bills.bill.get(0).title + "\n");

		// Bill
		Bill bill = votesClass.getBill(bills.bill.get(0).billId);
		System.out.println("Bill " + bill.billNumber + " has " + bill.sponsors.sponsor.size() + " sponsors" );
		Bill.Sponsors.Sponsor sponsor = bill.sponsors.sponsor.get(0);
		System.out.println("The first sponsorId is " + sponsor.candidateId + ", called " + sponsor.name );
		System.out.println("Bill " + bill.billNumber + " has " + bill.actions.action.size() + " actions" );
		Bill.Actions.Action actionOfBill = bill.actions.action.get(0);
		System.out.println("The first actionId is " + actionOfBill.actionId + ", dated " + actionOfBill.statusDate + "\n" );
		
		// by Action
		BillAction action = votesClass.getBillAction(actionOfBill.actionId);
		System.out.println( "Action for actionId " + action.actionId + " is titled " + action.title + "\n");
		
		// Votes for Action
		BillActionVotes billActionVotes = votesClass.getBillActionVotes(actionOfBill.actionId);
		System.out.println( "There are " + billActionVotes.vote.size() + " votes for actionId " + actionOfBill.actionId);
		System.out.println("The first action is " + billActionVotes.vote.get(0).action + "\n" );
		
		// Votes by sponsor
		billActionVotes = votesClass.getBillActionVoteByOfficial(actionOfBill.actionId, sponsor.candidateId);
		System.out.println( "There are " + billActionVotes.vote.size() + " votes for actionId " + actionOfBill.actionId + " by sponsor " + sponsor.name);
		System.out.println("The first action is " + billActionVotes.vote.get(0).action + "\n" );
		
		// Vetos
		try {
			BillVetoes billVetoes = votesClass.getVetoes(sponsor.candidateId);
			System.out.println( "There are " + billVetoes.bill.size() + " bills that were vetoed by sponsor " + sponsor.name);
		} catch (VoteSmartErrorException e) { handleError(e); }
			

		// by Sponsor, Category
		bills = votesClass.getBillsBySponsorCategory(sponsor.candidateId, votesCategory.categoryId);
		System.out.println("There are " + bills.bill.size() + " bills for sponsor " + sponsor.name + " in category " + votesCategory.name + "\n");

		// by Sponsor, Year
		bills = votesClass.getBillsBySponsorYear(sponsor.candidateId, "2013");
		System.out.println("There are " + bills.bill.size() + " bills for sponsor " + sponsor.name + " in 2013\n");

		// disable cache for this one ... 
		VoteSmart.setCache(false);
		
		// 10 bills from CA
		bills = votesClass.getBillsByStateRecent("10", state.stateId);
		System.out.println("10 recent bills from " + state.name + " are:");
		for( BillMin abill: bills.bill ) {
			System.out.print( abill.billNumber + ", ");
		}
		System.out.println("\n");
		
		// and turn it back on after this ... 
		VoteSmart.setCache(true);
		
		// ByBillNumber
		String billNumber = bills.bill.get(0).billNumber;
		// should get one of the most recent bills, but we just want to keep using the cache for 
		// the purpose of this example program.
		bills = votesClass.getByBillNumber("S Amdt 2013");
		System.out.println("There are " + bills.bill.size() + " bills with billNumber \"" + billNumber + "\"\n");

		// BillsByOfficial
		BillsByOfficial billsByOffical = votesClass.getByOfficial(candidate.candidateId, candidate.officeId);
		System.out.println("There are " + billsByOffical.bill.size() + " bills by official " + candidate.firstName + " " + candidate.lastName + " in office " + candidate.officeName + "\n");
			
		// Election Class
		ElectionClass electionClass = new ElectionClass();
		
		// look up 2012 elections
		Elections elections = electionClass.getElectionByYearState("2012", state.stateId);
		System.out.println("There are " + elections.election.size() + " election results in 2012 in " + state.name);
		Elections.ElectionStage election = elections.election.get(0);
		System.out.println("The first electionId is " + election.electionId + ", titled " + election.name );
		System.out.println("There are " + elections.election.get(0).stage.size() + " election stages in election " + election.name );
		Elections.ElectionStage.Stage stage = elections.election.get(0).stage.get(0);
		System.out.println("The first stageId is " + stage.stageId + ", called " + stage.name+ "\n");

		// a specific election 
		elections = electionClass.getElection(election.electionId);
		System.out.println("There are " + elections.election.size() + " election results for electionId " + election.electionId + "\n");
		election = elections.election.get(0);
		
		String zip5 = addressOffical.office.get(0).address.zip.substring(0, 5);
		try {
			// an election for a zip-code
			ElectionByZip electionByZip = electionClass.getElectionByZip(zip5);
			System.out.println("There are " + electionByZip.election.size() + " election results for zip " + zip5 + "\n");
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		// candidates in a zip
		try {
			CandidateList zipCandidates = candidatesClass.getByZip(zip5);
			System.out.println("There are " + zipCandidates.candidate.size() + " candidates for zip " + zip5 + "\n");
		} catch (VoteSmartErrorException e) { handleError(e); }
				
		// get candidates for election
		CandidateList electionCandidates = candidatesClass.getByElection(election.electionId);
		System.out.println("There are " + electionCandidates.candidate.size() + " candidates for " + election.name + "\n");
		
		// Stage Candidates
		StageCandidates stageCandidates = electionClass.getStageCandidates(election.electionId, stage.stageId);
		System.out.println("There are " + stageCandidates.candidate.size() + " candidates and " + stageCandidates.election.size() + " elections for stageId " + stage.stageId);
		StageCandidates.Candidate stageCandidate = stageCandidates.candidate.get(0);
		System.out.println("The first stageCandidateId is " + stageCandidate.candidateId + ", who is " + stageCandidate.firstName + " " + stageCandidate.lastName );
		
		// Address for candidate campaign.
		try {
			AddressOffice addressStageCandidate = addressClass.getCampaign(stageCandidate.candidateId);
			System.out.println("There are " + addressStageCandidate.office.size() + " offices for " + addressStageCandidate.candidate.firstName + " " + addressStageCandidate.candidate.firstName);
		} catch (VoteSmartErrorException e) { handleError(e); }

		try {
			WebAddress webStageCandidate = addressClass.getCampaignWebAddress(stageCandidate.candidateId);
			System.out.println("There are " + webStageCandidate.address.size() + " web addresses for " + webStageCandidate.candidate.firstName + " " + webStageCandidate.candidate.firstName);
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		try {
			AddressOffice electionAddressOffice = addressClass.getCampaignByElection(election.electionId);
			System.out.println("There are " + electionAddressOffice.office.size() + " offices in election " + election.name);
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		// Ballot Measures
		MeasureClass measureClass = new MeasureClass();
		
		// Get measures in 2012 state election
		Measures measures = measureClass.getMeasuresByYearState("2012", state.stateId);
		System.out.println("There are " + measures.measure.size() + " measures in 2012 in " + state.name );
		System.out.println("The first measureId is " + measures.measure.get(0).measureId + "\n");
		
		Measure measure = measureClass.getMeasure(measures.measure.get(0).measureId);
		System.out.println("The first measure is titled " + measure.title + "\n" );
		
		// Local Class
		LocalClass localClass = new LocalClass();
		
		// get counties
		Counties counties = localClass.getCounties(state.stateId);
		System.out.println("There are " + counties.county.size() + " counties in " + state.name );
		Counties.County county = counties.county.get(0);
		System.out.println("The first county is " + county.name + "\n");
		
		// get cities
		Cities cities = localClass.getCities(state.stateId);
		System.out.println("There are " + cities.city.size() + " cities in " + state.name );
		Cities.City city = cities.city.get(0);
		System.out.println("The first city is " + city.name + "\n");

		// county official
		LocalCandidateList localCandidates = localClass.getOfficials(county.localId);
		System.out.println("There are " + localCandidates.candidate.size() + " local officials in " + county.name );
		LocalCandidateList.Candidate localCandidate = localCandidates.candidate.get(0);
		System.out.println("The first candidateId is " + localCandidate.candidateId + ", called " + localCandidate.firstName + " " + localCandidate.lastName + "\n" );
		
		// City official
		localCandidates = localClass.getOfficials(city.localId);
		System.out.println("There are " + localCandidates.candidate.size() + " local officials in " + city.name );
		localCandidate = localCandidates.candidate.get(0);
		System.out.println("The first candidateId is " + localCandidate.candidateId + ", called " + localCandidate.firstName + " " + localCandidate.lastName + "\n" );
		
		// some more officialsClass
		candidates = officialsClass.getByLastname(candidate.lastName);
		System.out.println("There are " + candidates.candidate.size() + " candidates with last name " + candidate.lastName + "\n" );
		
		// by Levenshtein
		candidates = officialsClass.getByLevenshtein(candidate.lastName);
		System.out.println("There are " + candidates.candidate.size() + " candidates with last name similar to " + candidate.lastName + "\n" );


		// by Zip
		candidates = officialsClass.getByZip(zip5);
		System.out.println("There are " + candidates.candidate.size() + " candidates in zip " + zip5 + "\n" );
		
		// Done?
		System.out.println("And that, my friends, is all things " + state.name);
	}
}
