package fr.nexhub.homedia.benchmark

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.By
import com.nexhub.utils.testing.SKIP_TAG


fun MacrobenchmarkScope.skip() {
    device.findObject(By.res(SKIP_TAG)).click()
}
