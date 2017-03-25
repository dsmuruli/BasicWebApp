package co.ds.mybatis.mapper;

import co.ds.bean.Topic;
import com.google.inject.Inject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TopicMapperTest extends MapperTestBase {

    @Inject
    TopicMapper topicMapper;

    @Test
    public void should_list(){
        final List<Topic>topicList = topicMapper.list();
        assertEquals("Topic list should contain 4 records", 4, topicList.size());
    }
}
