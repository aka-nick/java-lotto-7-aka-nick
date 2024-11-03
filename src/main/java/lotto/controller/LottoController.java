package lotto.controller;

import java.util.List;
import lotto.business.LottoService;
import lotto.model.WinningLotto;
import lotto.value.LottoNumbers;
import lotto.value.WinningStatistics;
import lotto.value.Won;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final LottoService lottoService;

    public LottoController(LottoInput lottoInput,
                           LottoOutput lottoOutput,
                           LottoService lottoService) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
        this.lottoService = lottoService;
    }

    public void doHandleLotto() {
        Won wonOfPurchased = lottoInput.askForPurchasePrice();
        List<LottoNumbers> issuedLottoNumbers = lottoService.buyLotto(wonOfPurchased);
        lottoOutput.showIssuedLottoNumbers(issuedLottoNumbers);

        WinningLotto winningLotto = lottoInput.askForWinningLotto();
        WinningStatistics winningStatistics = lottoService.checkWinningResults(winningLotto);
        lottoOutput.announceWinningStatistics(winningStatistics);
    }

}
