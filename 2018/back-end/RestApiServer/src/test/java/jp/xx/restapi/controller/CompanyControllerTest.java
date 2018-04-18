package jp.xx.restapi.controller;

import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.xx.restapi.company.controller.CompanyController;
import jp.xx.restapi.company.dto.CompanySearchConditionDto;
import jp.xx.restapi.company.dto.CompanySearchResultRowDto;
import jp.xx.restapi.company.request.CompanySearchConditionRequest;
import jp.xx.restapi.company.service.CompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    // MVC用モック
    @Autowired
    private MockMvc mvc;
    
    // Service層をモックする
    @MockBean
    private CompanyService companyService;

    // モックオブジェクトの挿入対象
    @InjectMocks
    private CompanyController controller;

    /**
     * /searchの正常系テスト
     * @throws Exception
     */
    @Test
    public void search_success() throws Exception {

        /**
         * Service層のモック設定
         */
        List<CompanySearchResultRowDto> list = new ArrayList<CompanySearchResultRowDto>();
        CompanySearchResultRowDto dto = new CompanySearchResultRowDto();
        dto.setCompanyId(1);
        dto.setCompanyName("A社");
        dto.setJobCategoryLevel1("01");
        dto.setJobCategoryLevel2("02");
        list.add(dto);
        doReturn(list).when(companyService).searchFullFillCompanyList(any(CompanySearchConditionDto.class));

        
        /**
         * リクエストデータ作成
         */
        CompanySearchConditionRequest request = new CompanySearchConditionRequest();
        request.setJobCategoryLevel1("01");
        request.setJobCategoryLevel2("01");
        byte[] requestJson = convertRequestToJsonBytes(request);

        /**
         * テスト実行
         */
        mvc.perform(
            MockMvcRequestBuilders
                .post("/search")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("fullFillCompanyList[0].companyId",is(1)))
        .andExpect(jsonPath("fullFillCompanyList[0].companyName",is("A社")))
        .andExpect(jsonPath("fullFillCompanyList[0].jobCategoryLevel1",is("01")))
        .andExpect(jsonPath("fullFillCompanyList[0].jobCategoryLevel2",is("02")));
    }
    
    /**
     * リクエストオブジェクトからJSONバイト配列を生成する
     * 
     * @param request　リクエスト
     * @return JSONバイト配列
     * @throws Exception 例外
     */
    private <E> byte[] convertRequestToJsonBytes(E request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsBytes(request);
    }
}
