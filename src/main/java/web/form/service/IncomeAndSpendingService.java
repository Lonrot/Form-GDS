package web.form.service;

import web.form.model.incomeandspending.BaseIncomeAndSpending;

 public interface IncomeAndSpendingService {

    public String supportedYear();
    /**
     * Returns the view template path for the form
     */
    public String getFormView();

    /**
     * Returns the view to redirect to after a successful submission
     */
    public String getNextPage(Object flow);

    /**
     * Save the model to the database
     */
    void process(BaseIncomeAndSpending model);

    /**
     * Creates an appropriate model instance for this year
     */
    BaseIncomeAndSpending createModel();

}
