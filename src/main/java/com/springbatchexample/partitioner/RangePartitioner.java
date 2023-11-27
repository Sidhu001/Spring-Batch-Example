package com.springbatchexample.partitioner;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class RangePartitioner implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        // grid size: No Of Batches
        int min = 1;
        int max = 1000;
        int batchSize = (max - min) / gridSize + 1;
        System.out.println("batchSize: " + batchSize);
        System.out.println("noOfBatches: " + gridSize);
        Map<String, ExecutionContext> result = new HashMap<>();

        int number = 0;
        int start = min;
        int end = start + batchSize - 1;
        // 1 TO 500
        // 501 to 1000
        while(start <= max){
            ExecutionContext value = new ExecutionContext();
            result.put("partition" + number, value);

            if(end >= max){
                end = max;
            }

            value.putInt("minValue", start);
            value.putInt("maxValue", end);
            start += batchSize;
            end += batchSize;
            number++;
        }
        System.out.println("Partition result: " + result.toString());
        return result;
    }

}
