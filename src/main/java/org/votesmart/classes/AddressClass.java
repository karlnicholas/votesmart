package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.AddressAddress;
import org.votesmart.data.AddressOffice;
import org.votesmart.data.WebAddress;

/**
 * <pre>
 * Address Class
 * * - Required
 * * - Multiple rows
 * 
 * Address.getCampaign
 * This method grabs campaign office(s) and basic candidate information for the specified candidate.
 * Input: candidateId*
 * Output: {@link AddressOffice}  
 * 
 * Address.getCampaignWebAddress
 * This method grabs the campaign office's Web address(es) and basic candidate information for the specified candidate.
 * Input: candidateId*
 * Output: {@link WebAddress}
 * 
 * Address.getCampaignByElection
 * This method grabs campaign office(s) and basic candidate information for the specified election.
 * Input: electionId*
 * Output: {@link AddressOffice}
 * 
 * Address.getOffice
 * This method grabs office(s) and basic candidate information for the specified candidate.
 * Input: candidateId*
 * Output: {@link AddressOffice}
 * 
 * Address.getOfficeWebAddress
 * This method grabs office's Web address(es) and basic candidate information for the specified candidate.
 * Input: candidateId*
 * Output: {@link WebAddress}
 * 
 * Address.getOfficeByOfficeState
 * This method grabs office address and basic candidate information according to the officeId and state.
 * Input: officeId*, stateId (Default: 'NA')
 * Output: {@link AddressAddress}
 * 
 * ==== EXAMPLE USAGE =====
 * 
 * AddressClass addressClass = new AddressClass();
 * 
 * // address of Office (State Assembly)
 * AddressAddress addressOffice = addressClass.getOfficeByOfficeState(office.officeId, state.stateId);
 * 
 * // address of Official
 * AddressOffice addressOffical = addressClass.getOffice(candidate.candidateId)
 * 
 * // WebAddress of Official
 * WebAddress webAddressOffical = addressClass.getOfficeWebAddress(candidate.candidateId);
 *</pre>
 */
public class AddressClass extends ClassesBase {

	/**
	 * Constructor for testing purposes. 
	 * 
	 * @param api
	 */
	public AddressClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default constructor
	 */
	public AddressClass() throws VoteSmartException {
		super();
	}

	/**
	 * This method grabs campaign office(s) and basic candidate information for the specified candidate.
	 * 
	 * @param candidateId
	 * @return {@link AddressOffice}: address and list of office addresses.
	 */
	public AddressOffice getCampaign(String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Address.getCampaign", new ArgMap("candidateId", candidateId), AddressOffice.class );
	}
	
	/**
	 * This method grabs the campaign office's Web address(es) and basic candidate information for the specified candidate.
	 * 
	 * @param candidateId
	 * @return {@link WebAddress}: Candidate name and URL's
	 */
	public WebAddress getCampaignWebAddress(String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Address.getCampaignWebAddress", new ArgMap("candidateId", candidateId), WebAddress.class );
	}
	
	/**
	 * This method grabs campaign office(s) and basic candidate information for the specified election.
	 * 
	 * @param electionId
	 * @return {@link AddressOffice}: Candidate name and list of office addresses
	 */
	public AddressOffice getCampaignByElection(String electionId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Address.getCampaignByElection", new ArgMap("electionId", electionId), AddressOffice.class );
	}

	/**
	 * This method grabs office(s) and basic candidate information for the specified candidate.
	 * 
	 * @param candidateId
	 * @return {@link AddressOffice}: Candidate name and list of office addresses
	 */
	public AddressOffice getOffice(String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Address.getOffice", new ArgMap("candidateId", candidateId), AddressOffice.class );
	}
	
	/**
	 * This method grabs office's Web address(es) and basic candidate information for the specified candidate.
	 * 
	 * @param candidateId
	 * @return {@link WebAddress}: Candidate name and list of URL's 
	 */
	public WebAddress getOfficeWebAddress(String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Address.getOfficeWebAddress", new ArgMap("candidateId", candidateId), WebAddress.class );
	}
	
	/**
	 * This method grabs office address and basic candidate information according to the officeId and state.
	 * 
	 * @param officeId
	 * @return {@link AddressAddress}: Candidate name and list of offices 
	 */
	public AddressAddress getOfficeByOfficeState(String officeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Address.getOfficeByOfficeState", new ArgMap("officeId", officeId), AddressAddress.class );
	}
	
	/**
	 * This method grabs office address and basic candidate information according to the officeId and state.
	 * 
	 * @param officeId
	 * @param stateId
	 * @return {@link AddressAddress}: Candidate name and list of offices 
	 */
	public AddressAddress getOfficeByOfficeState(String officeId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Address.getOfficeByOfficeState", new ArgMap("officeId", officeId, "stateId", stateId), AddressAddress.class );
	}

}
