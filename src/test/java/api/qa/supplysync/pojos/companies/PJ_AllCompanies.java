package api.qa.supplysync.pojos.companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonIgnoreProperties (ignoreUnknown = true)
public class PJ_AllCompanies {

    private String id;
    private String blocked;
}
