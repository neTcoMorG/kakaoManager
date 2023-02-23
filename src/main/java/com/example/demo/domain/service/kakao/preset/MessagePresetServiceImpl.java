package com.example.demo.domain.service.kakao.preset;

import com.example.demo.domain.entity.message.common.*;
import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import com.example.demo.domain.entity.message.feed.ItemContent;
import com.example.demo.domain.repository.ButtonRepository;
import com.example.demo.domain.repository.FeedMessagePresetRepository;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagePresetServiceImpl implements MessagePresetService{
  private final FeedMessagePresetRepository feedMessagePresetRepository;
  private final ButtonRepository buttonRepository;
  private final ModelMapper modelMapper;
  @Override
  public void savePreset(MessagePreset messagePreset, String template) {
    if (template.equals("feed")) {
      createFeedMessagePreset((FeedMessagePreset) messagePreset);
    }
  }

  @Override
  public List<FeedObject> getPresetList(Long userId) {
    List<FeedMessagePreset> findList = feedMessagePresetRepository.findByUserId(userId);

//    modelMapper.typeMap(Button.class, com.example.demo.domain.service.kakao.message.json.common.Button.class).addMappings(mapping ->{
//      mapping.map(, FeedObject::setButtons);
//    });

    modelMapper.getConfiguration()
            .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
            .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);

    List<FeedObject> dtoResult = modelMapper.map(findList, new TypeToken<List<FeedObject>>() {}.getType());


    System.out.println();
    return dtoResult;
  }

  private void createFeedMessagePreset(FeedMessagePreset feedMessagePreset) {
    Link contentLink = feedMessagePreset.getContent().getLink();
    contentLink.setContent(feedMessagePreset.getContent());

    ItemContent itemContent = feedMessagePreset.getItemContent();
    for (Item item : itemContent.getItems()) {
      item.setItemContent(itemContent);
    }

    feedMessagePreset.getSocial().setFeedMessagePreset(feedMessagePreset);
    for (Button button : feedMessagePreset.getButtons()) {
      button.setFeedMessagePreset(feedMessagePreset);
    }

    for (Button button : feedMessagePreset.getButtons()) {
      button.setFeedMessagePreset(feedMessagePreset);
    }

    feedMessagePresetRepository.save(feedMessagePreset);

    List<Button> buttons = feedMessagePreset.getButtons();
    buttonRepository.saveAll(buttons);
    System.out.println();
  }
}
