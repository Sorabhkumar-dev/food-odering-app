package com.sorabh.grabfood.ui.fragments.qna;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FragmentQNABinding;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.ui.adapter.QNAAdapter;
import com.sorabh.grabfood.util.QNAData;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/qna/QNAFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FragmentQNABinding;", "job", "Lkotlinx/coroutines/CompletableJob;", "localRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "getLocalRepository", "()Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "setLocalRepository", "(Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "qnaAdapter", "Lcom/sorabh/grabfood/ui/adapter/QNAAdapter;", "getQnaAdapter", "()Lcom/sorabh/grabfood/ui/adapter/QNAAdapter;", "setQnaAdapter", "(Lcom/sorabh/grabfood/ui/adapter/QNAAdapter;)V", "createQna", "Lkotlinx/coroutines/Job;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupData", "", "startupInitializer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class QNAFragment extends androidx.fragment.app.Fragment {
    private final kotlinx.coroutines.CompletableJob job = null;
    private com.sorabh.grabfood.databinding.FragmentQNABinding binding;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.LocalDBRepository localRepository;
    @javax.inject.Inject()
    public com.sorabh.grabfood.ui.adapter.QNAAdapter qnaAdapter;
    
    public QNAFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.domain.repository.LocalDBRepository getLocalRepository() {
        return null;
    }
    
    public final void setLocalRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.LocalDBRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.ui.adapter.QNAAdapter getQnaAdapter() {
        return null;
    }
    
    public final void setQnaAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.QNAAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void startupInitializer() {
    }
    
    private final void setupData() {
    }
    
    private final kotlinx.coroutines.Job createQna() {
        return null;
    }
}