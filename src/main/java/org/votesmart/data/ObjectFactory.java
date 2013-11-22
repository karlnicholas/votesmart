package org.votesmart.data;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * <pre>
 * Required by JAXB unmarshaller. 
 * Instantiates all possible data/dom types.
 * An API user does not need to 
 * use this class.  
 * </pre>
 */
@XmlRegistry
public class ObjectFactory {

	public AddlBio createAddlBio() {
		return new AddlBio();
	}
	public AddressAddress createAddressAddress() {
		return new AddressAddress();
	}
	public AddressOffice createAddressOffice() {
		return new AddressOffice();		
	}
	public Bio createBio() {
		return new Bio();
	}
	public Bill createBill() {
		return new Bill();
	}
	public BillAction createBillAction() {
		return new BillAction();
	}
	public BillActionVotes createBillActionVotes() {
		return new BillActionVotes();
	}
	public Bills createBills() {
		return new Bills();
	}
	public BillsByOfficial createBillsyOfficial() {
		return new BillsByOfficial();
	}
	public BillVetoes createBillVetoes() {
		return new BillVetoes();
	}
	public Branches createBranches() {
		return new Branches();
	}
	public CandidateList createCandidateList() {
		return new CandidateList();
	}
	public CandidateRating createCandidateRating() {
		return new CandidateRating();
	}
	public Categories createCategories() {
		return new Categories();
	}
	public Cities createCities() {
		return new Cities();
	}
	public Committee createCommittee() {
		return new Committee();
	}
	public CommitteeMembers createCommitteeMembers() {
		return new CommitteeMembers();
	}
	public Committees createCommittees() {
		return new Committees();
	}
	public CommitteeTypes createCommitteeTypes() {
		return new CommitteeTypes();
	}
	public Counties createCounties() {
		return new Counties();
	}
	public DistrictList createDistrictList() {
		return new DistrictList();
	}
	public ElectionByZip createElectionByZip() {
		return new ElectionByZip();
	}
	public Elections createElections() {
		return new Elections();
	}
	public ErrorBase createError() {
		return new ErrorBase();
	}
	public Leaders createLeaders() {
		return new Leaders();
	}
	public Leadership createLeadership() {
		return new Leadership();
	}
	public Levels createLevels() {
		return new Levels();
	}
	public LocalCandidateList createLocalCandidateList() {
		return new LocalCandidateList();
	}
	public Measure createMeasure() {
		return new Measure();
	}
	public Measures createMeasures() {
		return new Measures();
	}
	public Npat createNpat() {
		return new Npat();
	}
	public Offices createOffices() {
		return new Offices();
	}
	public OfficeTypes createOfficeTypes() {
		return new OfficeTypes();
	}
	public Rating createRating() {
		return new Rating();
	}
	public Sig createSig() {
		return new Sig();
	}
	public SigRating createSigRating() {
		return new SigRating();
	}
	public Sigs createSigs() {
		return new Sigs();
	}
	public State createState() {
		return new State();
	}
	public StageCandidates createStageCandidates() {
		return new StageCandidates();
	}
	public StateList createStateList() {
		return new StateList();
	}
	public VotesCategories createVotesCategories() {
		return new VotesCategories();
	}
	public WebAddress createWebAddress() {
		return new WebAddress();
	}
}
