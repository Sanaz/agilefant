package fi.hut.soberit.agilefant.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import fi.hut.soberit.agilefant.business.LabelBusiness;
import fi.hut.soberit.agilefant.model.Label;

@Component("labelAction")
@Scope("prototype")
public class LabelAction extends ActionSupport {

    private static final long serialVersionUID = 2732120227422713963L;

    private Integer labelId;

    private String labelName;

    private List<Label> labels = new ArrayList<Label>();

    private Integer storyId;
    
    private List<String> labelNames;
    
    @Autowired
    private LabelBusiness labelBusiness;

    public String delete() {
        labelBusiness.delete(getLabelId());
        return Action.SUCCESS;
    }

    public String lookupLabels() {
        labels = labelBusiness.lookupLabelsLike(labelName);
        return Action.SUCCESS;
    }

    public String addStoryLabels() {
        labelBusiness.createStoryLabels(labelNames, storyId);
        return Action.SUCCESS;
    }
    
    // AUTOGENERATED

    public void setLabelBusiness(LabelBusiness labelBusiness) {
        this.labelBusiness = labelBusiness;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getLabelId() {
        return labelId;
    }


    public void setLabelNames(List<String> labelNames) {
        this.labelNames = labelNames;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public List<String> getLabelNames() {
        return labelNames;
    }


    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelName() {
        return labelName;
    }
    
    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

}
