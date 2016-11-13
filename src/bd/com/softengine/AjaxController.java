package bd.com.softengine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 11/01/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 11/01/16
 * Version : 1.0
 */

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
    /*@Autowired
    private AjaxService ajaxService;
    @Autowired
    private ChamberService chamberService;

    @RequestMapping(value = "getPatientList.se", method = RequestMethod.GET)
    public
    @ResponseBody
    String getPatientList(@RequestParam String name,
                          @RequestParam String father,
                          @RequestParam String cellNo,
                          @RequestParam String son,
                          //@RequestParam long para,
                          //@RequestParam long village,
                          @RequestParam String reference,
                          @RequestParam String nickName) {
        // Para para = chamberService.getPara(paraId);
        // Village village = chamberService.getVillage(villageId);
        PatientSearchBean searchBean = new PatientSearchBean();
        searchBean.setName(name.equals("") ? "%" : "%" + name + "%");
        searchBean.setFather(father.equals("") ? "%" : "%" + father + "%");
        searchBean.setCellNo(cellNo.equals("") ? "%" : "%" + cellNo + "%");
        searchBean.setSon(son.equals("") ? "%" : "%" + son + "%");
        //searchBean.setPara(para.equals("") ? "%" : "%" + para + "%");
        //searchBean.setVillage(village.equals("") ? "%" : "%" + village + "%");
        searchBean.setReference(reference.equals("") ? "%" : "%" + reference + "%");
        searchBean.setNickName(nickName.equals("") ? "%" : "%" + nickName + "%");
        return new Gson().toJson(ajaxService.getPatientList(searchBean));
    }*/

}
