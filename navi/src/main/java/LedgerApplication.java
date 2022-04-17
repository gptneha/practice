import com.ledger.loansysystem.enums.LoanRequestEnum;
import com.ledger.loansysystem.exceptions.InvalidRequestInput;
import com.ledger.loansysystem.response.BalanceResponse;
import com.ledger.loansysystem.response.LoanResponse;
import com.ledger.loansysystem.service.ILoanRequestProcessor;
import com.ledger.loansysystem.service.LoanRequestProcessorFactory;

import java.io.BufferedReader;
import java.io.FileReader;

public class LedgerApplication {


    public static void main(String[] args) {
        System.out.println("in main");
        //TODO:: Read input file in thiss method and print output to console
        try {
            String line = "";
            String splitBy = ",";
            BufferedReader br = new BufferedReader(new FileReader("/Users/neha.gupta@zomato.com/Downloads/practice/navi/src/main/java/com/ledger/loansysystem/input.csv"));
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(splitBy);
                if (employee == null || employee.length == 0) {
                    throw new InvalidRequestInput("No input provided");
                }
                String action = employee[0];
                ILoanRequestProcessor loanRequestProcessor = LoanRequestProcessorFactory.getProcessor(action);
                if (loanRequestProcessor == null) {
                    throw new InvalidRequestInput("Invalid action");
                }
                LoanResponse loanResponse = loanRequestProcessor.processRequest(line);
                if (loanResponse.isSuccess() && loanResponse.getData() != null && LoanRequestEnum.BALANCE.equals(LoanRequestEnum.valueOf(action))) {
                    BalanceResponse balanceResponse = (BalanceResponse) loanResponse.getData();
                    System.out.println(balanceResponse.getBankName() + " " + balanceResponse.getName() + " " + balanceResponse.getPaidAmount() + " " + balanceResponse.getEmiNumber());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
