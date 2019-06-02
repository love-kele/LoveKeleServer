package com.kele.respone;

import com.kele.context.robot.Intent;
import com.kele.context.robot.Results;

public class RobotResponse {

    private Intent intent;

    private Results[] results;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Results[] getResults() {
        return results;
    }

    public void setResults(Results[] results) {
        this.results = results;
    }
}
