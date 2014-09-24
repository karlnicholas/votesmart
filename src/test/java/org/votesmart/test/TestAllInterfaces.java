package org.votesmart.test;


import static org.junit.Assert.*;

import org.junit.Test;
import org.votesmart.api.VoteSmartErrorException;
import org.votesmart.classes.*;
import org.votesmart.data.*;
import org.votesmart.testapi.TestVoteSmartBase;

/**
 * The goal here is just to make (most) every possible call.
 *
 */
public class TestAllInterfaces extends TestVoteSmartBase {

	public void handleError(VoteSmartErrorException e) {
//		System.out.println("Error: " + e.errorBase.errorMessage);
//		System.out.println("	Details: " + e.method + " " + e.argMap + "\n");
	}

	@Test
	public void test() throws Exception {
		// put a votesmart.properties file in the /src/main/resources directory
		// There is an sample one there now (votesmartsample.properties)
		// put your VoteSmart API key in it and set a caching directory, 
		// then rename it to (votesmart.properties).
		
		// Get general Information about offices
		OfficeClass officeClass = new OfficeClass(this);
		
		// get Office.getBranches
		Branches branches = officeClass.getBranches();
		assertEquals( branches.branch.size(), 3);
		Branches.Branch officeBranch = branches.branch.get(1);
		assertEquals( officeBranch.name , "Legislative");
		
		// Office.getTypes
		OfficeTypes officeTypes = officeClass.getTypes();
		assertEquals( officeTypes.type.size(), 10);
		OfficeTypes.Type officeType  = officeTypes.type.get(5);
		assertEquals( officeType.name, "State Legislature");
		
		// Office.getLevels
		Levels levels = officeClass.getLevels();
		assertEquals( levels.level.size(), 3);
		Levels.Level officeLevel = levels.level.get(1);
		assertEquals( officeLevel.name, "State");

		// Office getOfficesByLevel
		Offices offices = officeClass.getOfficesByLevel(officeLevel.officeLevelId);
		assertEquals( offices.office.size(), 366);

		// Office getOfficesByType
		offices = officeClass.getOfficesByType(officeType.officeTypeId);
		assertEquals( offices.office.size(), 3);

		// Hold office information for later use.
		Offices.Office office;
		
		// Office getOfficesByTypeLevel
		offices = officeClass.getOfficesByTypeLevel(officeType.officeTypeId, officeLevel.officeLevelId);
		assertEquals( offices.office.size(), 3);
		office = offices.office.get(0);
		assertEquals( office.officeId, "7" );

		// Office getOfficesByBranchLevel
		offices = officeClass.getOfficesByBranchLevel(officeBranch.officeBranchId, officeLevel.officeLevelId);
		assertEquals( offices.office.size(), 3);
		office = offices.office.get(0);
		assertEquals( office.name, "State Assembly");
		
		// Determine California State Id
		StateClass stateClass = new StateClass(this);
		StateList allStates = stateClass.getStateIDs();
		StateList.List.State state = null;
		for( StateList.List.State aState: allStates.list.state ) {
			if (aState.name.equals("California")) {
				assertEquals( aState.stateId, "CA");
				state = aState;
				break;
			}
		}
		// Get State Details
		State stateDetail = stateClass.getState(state.stateId);
		assertEquals( stateDetail.details.area, "158,693 sq mi");
		assertEquals( stateDetail.details.bird, "California Valley Quail" );
		assertEquals( stateDetail.details.bicameral, "t");
		
		// Districts
		DistrictClass districtClass = new DistrictClass(this);

		DistrictList districtList = districtClass.getByOfficeState(office.officeId, state.stateId);
		assertEquals( districtList.district.size(), 80);
		DistrictList.District district = districtList.district.get(0);
		assertEquals( district.name, "1" );

		// Officials
		OfficialsClass officialsClass = new OfficialsClass(this);

		// Officials		
		CandidateList candidates = officialsClass.getStatewide();
		assertEquals( candidates.candidate.size(), 455 );;
		
		// Officials for CA
		candidates = officialsClass.getStatewide(state.stateId);
		assertEquals( candidates.candidate.size(), 1862 );
		CandidateList.Candidate candidate = candidates.candidate.get(0);
		assertEquals( candidate.candidateId, "114804" );
		assertEquals( candidate.firstName, "Roger" );
		
		// Officials for last officeType (Legislature), for state
		candidates = officialsClass.getByOfficeTypeState(officeType.officeTypeId, state.stateId);
		assertEquals( candidates.candidate.size(), 119 );
		candidate = candidates.candidate.get(0);
		assertEquals( candidate.candidateId, "81542");

		// Officials for last office (State Assembly), for state
		candidates = officialsClass.getByOfficeState(office.officeId, state.stateId);
		assertEquals( candidates.candidate.size(), 79 );

		CandidatesClass candidatesClass = new CandidatesClass(this);
		// Candidates for last office, for state
		candidates = candidatesClass.getByOfficeState(office.officeId, state.stateId);
		assertEquals( candidates.candidate.size(), 238 );


		// Candidates for last office, for state
		candidates = candidatesClass.getByOfficeTypeState(officeType.officeTypeId, state.stateId);
		assertEquals( candidates.candidate.size(), 309);

		// candidates for district
		try {
			candidates = candidatesClass.getByDistrict(district.districtId);
			assertEquals( candidates.candidate.size(), 2 );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		try {
			CandidateList candidatesByLastName = candidatesClass.getByLastname(candidate.lastName);
			assertEquals( candidatesByLastName.candidate.size(), 1 );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		try {
			CandidateList candidatesByLastName = candidatesClass.getByLevenshtein(candidate.lastName);
			assertEquals( candidatesByLastName.candidate.size(), 2 );
		} catch (VoteSmartErrorException e) { handleError(e); }

		// Addresses of  
		AddressClass addressClass = new AddressClass(this);
		
		// address of Office (State Assembly)
		AddressAddress addressOffice = addressClass.getOfficeByOfficeState(office.officeId, state.stateId);
		assertEquals( addressOffice.office.size(), 179 );
		assertEquals( addressOffice.office.get(0).address.street, "3 Park Plaza, Suite 150" );  
		assertEquals( addressOffice.office.get(0).address.city, "Irvine" );
		assertEquals( addressOffice.office.get(0).address.state, "CA" );
		assertEquals( addressOffice.office.get(0).address.zip, "92614");
		
		
		
		// address of Official
		AddressOffice addressOffical = addressClass.getOffice(candidate.candidateId);
		assertEquals( addressOffical.office.size(), 2);
		assertEquals( addressOffical.office.get(0).address.street, "1150 Osos Street, Suite 207" );
		assertEquals( addressOffical.office.get(0).address.city, "San Luis Obispo" );
		assertEquals( addressOffical.office.get(0).address.state, "CA" );
		assertEquals( addressOffical.office.get(0).address.zip, "93401" );

		// WebAddress of Official
		WebAddress webAddressOffical = addressClass.getOfficeWebAddress(candidate.candidateId);
		assertEquals( webAddressOffical.address.size(), 3 );
		assertEquals( webAddressOffical.address.get(0).webAddress, "Assemblymember.Achadjian@assembly.ca.gov" );
		
		// Candidate biographical 
		CandidateBioClass candidateBioClass = new CandidateBioClass(this);
		
		// Bio of Official
		Bio bio = candidateBioClass.getBio(candidate.candidateId);
		assertEquals( bio.candidate.birthDate, "" );
		assertEquals( bio.candidate.birthPlace, "Lebanon" );
		assertEquals( bio.candidate.gender, "Male" );
		assertEquals( bio.candidate.profession.experience.get(0).title, "Small Business Owner" );
		assertEquals( bio.candidate.religion, "" );
		assertEquals( bio.office.committee.size(), 8 );
		assertEquals( bio.office.committee.get(0).committeeName, "Accountability and Administrative Review");
		
		// save committee for later
		Bio.Office.Committee committeeByBio = bio.office.committee.get(0);
		
		try {
			AddlBio addlBio = candidateBioClass.getAddlBio(candidate.candidateId);
			assertEquals( addlBio.additional.item.size(), 0 );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		// Committee class
		CommitteeClass committeeClass = new CommitteeClass(this);

		Committee committee = committeeClass.getCommittee(committeeByBio.committeeId);
		assertEquals( committee.jurisdiction, "Primary jurisdictions are identifying savings and efficiencies in the management of state government, reviewing and studying the implementation, operation, and effectiveness of state programs and agencies.");
		assertEquals( committee.committeeTypeId, "H");

		CommitteeTypes committeeTypes = committeeClass.getTypes();
		assertEquals( committeeTypes.type.size(), 3);
		// save committeeType for later
		CommitteeTypes.Type committeeType = null;
		for (CommitteeTypes.Type searchType:  committeeTypes.type ) {
			if (searchType.committeeTypeId.equals(committee.committeeTypeId) ) {
				committeeType = searchType;
				break;
			}
		}
		assertEquals( committeeType.name, "House" );

		// CommitteeMembers class
		CommitteeMembers committeeMembers = committeeClass.getCommitteeMembers(committee.committeeId); 
		assertEquals( committeeMembers.member.size(), 13); 

		// Committees class
		Committees committees = committeeClass.getCommitteesByTypeState(committeeType.committeeTypeId, state.stateId);
		assertEquals( committees.committee.size(), 36);
		
		// Leadership class
		LeadershipClass leadershipClass = new LeadershipClass(this);
		Leadership leadership = leadershipClass.getPositions();
		assertEquals( leadership.position.size(), 36);
		
		// all positions
		leadership = leadershipClass.getPositions(state.stateId);
		assertEquals( leadership.position.size(), 28 );

		// all positions for office in state
		leadership = leadershipClass.getPositions(state.stateId, office.officeId);
		assertEquals( leadership.position.size(), 19 );
		Leadership.Position position = leadership.position.get(0);
		assertEquals( position.name, "Speaker" );

		// oficials for this position in state
		Leaders leaders = leadershipClass.getOfficials(position.leadershipId, state.stateId);
		assertEquals( leaders.leader.size(), 1 );
		Leaders.Leader leader = leaders.leader.get(0);
		assertEquals( leader.candidateId, "70372");
		
		// Npat class
		NpatClass npatClass = new NpatClass(this);
		// Npat if it exists
		Npat npat = npatClass.getNpat(leader.candidateId);
		assertEquals( npat.surveyMessage, "Toni G. Atkins's processing deadline has not passed. The result of Toni G. Atkins's Political Courage Test will be released in upcoming weeks.<br><br>Deadline for returning the National Political Awareness Test is 10/08/2014");
		
		// Rating class
		RatingClass ratingClass = new RatingClass(this);
		// all categories
		Categories categories = ratingClass.getCategories();
		assertEquals( categories.category.size(), 37 );
		
		// state categories
		categories = ratingClass.getCategories(state.stateId);
		assertEquals( categories.category.size(), 23 );
		CategoryMin category = categories.category.get(0);
		assertEquals( category.categoryId, "2" );
		
		// state sigs (Special Interest Groups)
		Sigs sigs = ratingClass.getSigList(category.categoryId, state.stateId);
		assertEquals( sigs.sig.size(), 5);
		Sigs.Sig sigsSig = sigs.sig.get(0);
		assertEquals( sigsSig.name,  "California Abortion and Reproductive Rights League");
		
		// Sig
		Sig sig = ratingClass.getSig(sigs.sig.get(0).sigId);
		// there be special characters here
		assertEquals( sig.description, "This group is now NARAL Pro-Choice California. Its archives are kept here as a public service."
+"\n\n"
+"Accelerating life science success for Southern California");
		assertEquals( sig.address, "111 Pine Street, Suite 1500");
		
		// SigRatings
		SigRating sigRatings = ratingClass.getSigRatings(sig.sigId);
		assertEquals( sigRatings.rating.size(), 1 );
		SigRating.Rating sigRating = sigRatings.rating.get(0);
		assertEquals( sigRating.ratingId, "5613" );

		// Sig ratings for Candidate
		CandidateRating candidateRating = ratingClass.getCandidateRating(leader.candidateId);
		assertEquals( candidateRating.rating.size(), 83);
		
		// Rating done by SIG group
		Rating rating = ratingClass.getRating(sigRating.ratingId);
		assertEquals( rating.candidateRating.size(), 117 );
		Rating.CandidateRating ratingCandidateRating = rating.candidateRating.get(0);
		assertEquals( ratingCandidateRating.rating, "100");
		
		// Votes class
		VotesClass votesClass = new VotesClass(this);
		
		// total votesCategories
		VotesCategories votesCategories = votesClass.getCategories("2013");
		assertEquals( votesCategories.category.size(), 33 );		
		
		// for CA
		votesCategories = votesClass.getCategories("2013", state.stateId);
		assertEquals( votesCategories.category.size(), 24 );
		CategoryMin votesCategory = votesCategories.category.get(0); 
		assertEquals( votesCategory.categoryId, "2" );
		assertEquals( votesCategory.name, "Abortion" );

		// for category, for 2013, for CA
		Bills bills = votesClass.getBillsByCategoryYearState(votesCategory.categoryId, "2013", state.stateId);
		assertEquals( bills.bill.size(), 1 );

		// by Official, Category, Office
		bills = votesClass.getBillsByOfficialCategoryOffice(leader.candidateId, votesCategory.categoryId);
		assertEquals( bills.bill.size(), 3 );

		// by Official, Year, Office
		bills = votesClass.getBillsByOfficialYearOffice(candidate.candidateId, "2013", office.officeId);
		assertEquals( bills.bill.size(), 29 );

		// by Official, Category, Office
		bills = votesClass.getBillsByOfficialCategoryOffice(candidate.candidateId, votesCategory.categoryId, office.officeId);
		assertEquals( bills.bill.size(), 2 );
		assertEquals( bills.bill.get(0).billId, "16725" );
		assertEquals( bills.bill.get(0).title, "Authorizes Certain Individuals to Perform Aspiration Abortion Procedures");

		// Bill
		Bill bill = votesClass.getBill(bills.bill.get(0).billId);
		assertEquals( bill.billNumber, "AB 154");
		Bill.Sponsors.Sponsor sponsor = bill.sponsors.sponsor.get(0);
		assertEquals( sponsor.candidateId, "70372" );
		assertEquals( sponsor.name, "Toni G. Atkins" );
		assertEquals( bill.actions.action.size(), 5 );
		Bill.Actions.Action actionOfBill = bill.actions.action.get(1);
		assertEquals( actionOfBill.actionId, "46074" );
		assertEquals( actionOfBill.statusDate, "2013-08-30" );
		
		// by Action
		BillAction action = votesClass.getBillAction(actionOfBill.actionId);
		assertEquals( action.actionId, "46074" );
		assertEquals( action.title, "Authorizes Certain Individuals to Perform Aspiration Abortion Procedures");
		
		// Votes for Action
		BillActionVotes billActionVotes = votesClass.getBillActionVotes(actionOfBill.actionId);
		assertEquals( billActionVotes.vote.size(), 78 );
		assertEquals( billActionVotes.vote.get(0).action, "Nay" );
		
		// Votes by sponsor
		billActionVotes = votesClass.getBillActionVoteByOfficial(actionOfBill.actionId, sponsor.candidateId);
		assertEquals( billActionVotes.vote.size(), 1 );
		assertEquals( billActionVotes.vote.get(0).action, "Yea" );
		
		// Vetos
		try {
			BillVetoes billVetoes = votesClass.getVetoes(sponsor.candidateId);
			assertEquals( billVetoes.bill.size(), 0 );
		} catch (VoteSmartErrorException e) { handleError(e); }
			

		// by Sponsor, Category
		bills = votesClass.getBillsBySponsorCategory(sponsor.candidateId, votesCategory.categoryId);
		assertEquals( bills.bill.size(), 1 );

		// by Sponsor, Year
		bills = votesClass.getBillsBySponsorYear(sponsor.candidateId, "2013");
		assertEquals( bills.bill.size(), 4 );
		
		// 10 bills from CA
		bills = votesClass.getBillsByStateRecent("10", state.stateId);
		StringBuilder billsNumbers = new StringBuilder();
		for( BillMin abill: bills.bill ) {
			billsNumbers.append( abill.billNumber + ", ");
		}
		assertEquals( billsNumbers.toString(), "H Amdt 1141, H Res 644, H J Res 124, HR 5272, S Amdt 3585, S Amdt 3583, HR 5230, S Amdt 3584, H Res 676, H Amdt 1098, ");
		
		// ByBillNumber
		String billNumber = bills.bill.get(0).billNumber;
		bills = votesClass.getByBillNumber(billNumber);
		assertEquals( bills.bill.size(), 1 );

		// BillsByOfficial
		BillsByOfficial billsByOffical = votesClass.getByOfficial(candidate.candidateId, candidate.officeId);
		assertEquals( billsByOffical.bill.size(), 181 );
			
		// Election Class
		ElectionClass electionClass = new ElectionClass(this);
		
		// look up 2012 elections
		Elections elections = electionClass.getElectionByYearState("2012", state.stateId);
		assertEquals( elections.election.size(), 2 );
		Elections.ElectionStage election = elections.election.get(0);
		assertEquals( election.electionId, "2343" );
		assertEquals( election.name, "California State Legislative 2012" );
		assertEquals( elections.election.get(0).stage.size(), 2 );
		Elections.ElectionStage.Stage stage = elections.election.get(0).stage.get(0);
		assertEquals( stage.stageId, "P" );
		assertEquals( stage.name, "Primary");

		// a specific election 
		elections = electionClass.getElection(election.electionId);
		assertEquals( elections.election.size(), 1 );
		election = elections.election.get(0);
		
		String zip5 = addressOffical.office.get(0).address.zip.substring(0, 5);
		try {
			// an election for a zip-code
			ElectionByZip electionByZip = electionClass.getElectionByZip(zip5);
			assertEquals( electionByZip.election.size(), 8 );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		// candidates in a zip
		try {
			CandidateList zipCandidates = candidatesClass.getByZip(zip5);
			assertEquals( zipCandidates.candidate.size(), 80 );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		// districts in a zip
		DistrictList zipDistrictList = districtClass.getByZip(zip5);
		assertEquals( zipDistrictList.district.size(), 8 );
		
		
		// get candidates for election
		CandidateList electionCandidates = candidatesClass.getByElection(election.electionId);
		assertEquals( electionCandidates.candidate.size(), 322 );
		
		// Stage Candidates
		StageCandidates stageCandidates = electionClass.getStageCandidates(election.electionId, stage.stageId);
		assertEquals( stageCandidates.candidate.size(), 316 );
		StageCandidates.Candidate stageCandidate = stageCandidates.candidate.get(0);
		assertEquals( stageCandidate.candidateId, "81542" );
		assertEquals( stageCandidate.lastName, "Achadjian" );
		
		// Address for candidate campaign.
		try {
			AddressOffice addressStageCandidate = addressClass.getCampaign(stageCandidate.candidateId);
			assertEquals( addressStageCandidate.office.size(), 2 );
		} catch (VoteSmartErrorException e) { handleError(e); }

		try {
			WebAddress webStageCandidate = addressClass.getCampaignWebAddress(stageCandidate.candidateId);
			assertEquals( webStageCandidate.address.size(), 1 );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		try {
			AddressOffice electionAddressOffice = addressClass.getCampaignByElection(election.electionId);
			assertEquals( electionAddressOffice.office.size(), 0 );
		} catch (VoteSmartErrorException e) { handleError(e); }
		
		// Ballot Measures
		MeasureClass measureClass = new MeasureClass(this);
		
		// Get measures in 2012 state election
		Measures measures = measureClass.getMeasuresByYearState("2012", state.stateId);
		assertEquals( measures.measure.size(), 13 );
		assertEquals( measures.measure.get(0).measureId, "1628" );
		
		Measure measure = measureClass.getMeasure(measures.measure.get(0).measureId);
		assertEquals( measure.title,  "Legislative Term Limits Reform Act of 2010" );
		
		// Local Class
		LocalClass localClass = new LocalClass(this);
		
		// get counties
		Counties counties = localClass.getCounties(state.stateId);
		assertEquals( counties.county.size(), 58 );
		Counties.County county = counties.county.get(0);
		assertEquals( county.name, "Alameda County");
		
		// get cities
		Cities cities = localClass.getCities(state.stateId);
		assertEquals( cities.city.size(), 238 );
		Cities.City city = cities.city.get(0);
		assertEquals( city.name, "Alameda");

		// county official
		LocalCandidateList localCandidates = localClass.getOfficials(county.localId);
		assertEquals( localCandidates.candidate.size(), 5);
		LocalCandidateList.Candidate localCandidate = localCandidates.candidate.get(0);
		assertEquals( localCandidate.candidateId, "82007" );
		assertEquals( localCandidate.lastName, "Carson" );
		
		// City official
		localCandidates = localClass.getOfficials(city.localId);
		assertEquals( localCandidates.candidate.size(), 4 );
		localCandidate = localCandidates.candidate.get(0);
		assertEquals( localCandidate.candidateId, "70069" );
		assertEquals( localCandidate.lastName, "Gilmore");
		
		// some more officialsClass
		candidates = officialsClass.getByLastname(candidate.lastName);
		assertEquals( candidates.candidate.size(), 1 );
		
		// by Levenshtein
		candidates = officialsClass.getByLevenshtein(candidate.lastName);
		assertEquals( candidates.candidate.size(), 3 );

		// by District
		candidates = officialsClass.getByDistrict(district.districtId);
		assertEquals( candidates.candidate.size(), 1 );

		// by Zip
		candidates = officialsClass.getByZip(zip5);
		assertEquals( candidates.candidate.size(), 19 );
	}
}
