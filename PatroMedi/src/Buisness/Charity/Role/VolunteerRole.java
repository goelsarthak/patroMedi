/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buisness.Charity.Role;

import Buisness.Charity.Organisation.VolunteerOrganisation;
import Buisness.EcoSystem;
import Buisness.Enterprise.CharityEnterprise;
import Buisness.Enterprise.Enterprise;
import Buisness.Network.Network;
import Buisness.Organisation.Organisation;
import Buisness.Role.Role;
import Buisness.UserAccount.UserAccount;
import UserInterface.CharityVolunteer.VolunteerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author manor
 */
public class VolunteerRole extends Role
{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organisation organisation, Enterprise enterprise,Network network, EcoSystem business)
    {
        return new VolunteerWorkAreaJPanel(userProcessContainer, account,(VolunteerOrganisation) organisation,(CharityEnterprise) enterprise,network, business); //To change body of generated methods, choose Tools | Templates.
    }
}
