package Chapter08_DisjointSets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonDisjointSets<T> {

  List<SetItem> setItems;
  HashMap<T, SetItem> valueSetitemMapping = new HashMap<>();

  class SetItem {

    T value;
    int last;
    int itemNum;

    SetItem(T value, int ItemNum) {
      this.value = value;
      this.last = -1;
      this.itemNum = ItemNum;
    }
  }

  public CommonDisjointSets(List<T> valueList) {
    setItems = new ArrayList<>();
    for (int i = 0; i < valueList.size(); i++) {
      T value = valueList.get(i);
      SetItem setItem = new SetItem(value, i);
      valueSetitemMapping.put(value, setItem);
      setItems.add(setItem);
    }
  }

  public int find(T value) {
    SetItem setItem = valueSetitemMapping.get(value);
    if (setItem.last < 0) {
      return setItem.itemNum;
    } else {
      return find(setItems.get(setItem.last).value);
    }
  }

  public T findRoot(T value) {
    int index = find(value);
    return setItems.get(index).value;
  }



  public void union(T value1, T value2) {
    SetItem setItem1 = valueSetitemMapping.get(value1);
    SetItem setItem2 = valueSetitemMapping.get(value2);
    setItem2.last = setItem1.itemNum;
  }
}
